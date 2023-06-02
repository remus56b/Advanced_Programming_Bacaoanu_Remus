Homework (2p)

✅The input may be a folder (containing .class files) or a .jar. You must explore it recursively.

✅Create the complete prototype, in the same manner as javap tool.

✅Identify all public classes annotated with @Test and invoke the methods annotated with @Test, whether static or not.

✅If a method requires primitive (at least int) or String arguments, generate mock values for them.

✅Print a statistics regarding the tests.


Bonus (2p)

✅Consider the case when the input files are .java files and compile the source code before analyzing them. (use Java Compiler, for example).

❌Use a bytecode manipulation and analysis framework, such as ASM, BCEL or Javassist in order to extract the bytecode of the class, perform bytecode instrumentation (inject code in some method) and generate dynamically a class.

