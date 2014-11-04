import java.lang.instrument.*;
import java.io.File;
import java.io.FileOutputStream;
import java.security.ProtectionDomain;
import java.util.List;
import java.util.ArrayList;
import java.util.regex.Pattern;


public class ClassDumperAgent implements ClassFileTransformer {

    private static String dumpDir;
    private static Pattern classes;

    public static void premain(String agentArgs, Instrumentation inst) {
        agentmain(agentArgs, inst);
    }

    public static void agentmain(String agentArgs, Instrumentation inst) {
        parseArgs(agentArgs);
        inst.addTransformer(new ClassDumperAgent(), true);

        Class[] classes = inst.getAllLoadedClasses();
        List<Class> candidates = new ArrayList<Class>();
        for (Class c : classes) {
            if (isCandidate(c.getName())) {
                candidates.add(c);
            }
        }
        try {
            if (! candidates.isEmpty()) {
                inst.retransformClasses(candidates.toArray(new Class[0]));
            }
        } catch (UnmodifiableClassException uce) {
        }
    }

    public byte[] transform(ClassLoader loader, String className,
                            Class redefinedClass, ProtectionDomain protDomain,
                            byte[] classBytes) {
        if (isCandidate(className)) {
            dumpClass(className, classBytes);
        }

        return null;
    }

    private static boolean isCandidate(String className) {
        if (className.charAt(0) == '[') {
            return false;
        }

        className = className.replace('/', '.');
        return classes.matcher(className).matches();
    }

    private static void dumpClass(String className, byte[] classBuf) {
        try {
            className = className.replace("/", File.separator);
            StringBuilder buf = new StringBuilder();
            buf.append(dumpDir);
            buf.append(File.separatorChar);
            int index = className.lastIndexOf(File.separatorChar);
            if (index != -1) {
                buf.append(className.substring(0, index));
            }
            String dir = buf.toString();
            new File(dir).mkdirs();

            String fileName = dumpDir +
                    File.separator + className + ".class";
            FileOutputStream fos = new FileOutputStream(fileName);
            fos.write(classBuf);
            fos.close();
        } catch (Exception exp) {
            exp.printStackTrace();
        }
    }

    private static void parseArgs(String agentArgs) {
        if (agentArgs != null) {
            String[] args = agentArgs.split(",");
            for (String arg: args) {
                String[] tmp = arg.split("=");
                if (tmp.length == 2) {
                    String name = tmp[0];
                    String value = tmp[1];
                    if (name.equals("dumpDir")) {
                        dumpDir = value;
                    } else if (name.equals("classes")) {
                        classes = Pattern.compile(value);
                    }
                }
            }
        }

        if (dumpDir == null) {
            dumpDir = ".";
        }

        if (classes == null) {
            classes = Pattern.compile(".*");
        }
    }
}
