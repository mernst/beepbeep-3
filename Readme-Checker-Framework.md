# Evidence that BeepBeep 3 has no resoure leaks.

To run the Resource Leak Checker:

1. Use Java 8 or 11, because BeepBeep 3 does not compile under Java 17.

2. Install the Checker Framework:
https://checkerframework.org/manual/#build-source

Note that the instructions include setting the CHECKERFRAMEWORK environment variable.

3. Obtain the BeepBeep 3 source code:

```
git clone https://github.com/mernst/beepbeep-3.git --branch resourceleak
cd beepbeep-3
```

4. Run the Resource Leak Checker:

```
ant -e check-resourceleak
```

The output is

```
Buildfile: /home/mernst/java/beepbeep-3-fork-mernst-branch-resourceleak/build.xml

...

BUILD SUCCESSFUL
Total time: 0 seconds
```

The lack of error messages (and of `@SuppressWarnings` in the BeepBeep 3 source code) proves that BeepBeep 3 contains no resource leaks.

5. Examine the changes made to BeepBeep 3 to support the Resource Leak Checker.

https://github.com/liflab/beepbeep-3/compare/master...mernst:beepbeep-3:resourceleak?expand=1

No annotations were needed, because BeepBeep 3 does not pass open resources among methods.

The Resource Leak Checker did reveal a bug, which was fixed here:

https://github.com/liflab/beepbeep-3/pull/71/files
