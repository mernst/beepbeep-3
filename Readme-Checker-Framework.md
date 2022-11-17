# Evidence that BeepBeep 3 has no null pointer exceptions.

1. Use Java 8 or 11, because BeepBeep 3 does not compile under Java 17.

2. Install the Checker Framework:
https://checkerframework.org/manual/#build-source

Note that the instructions include setting the CHECKERFRAMEWORK environment variable.

3. Obtain the BeepBeep 3 source code:

```
git clone https://github.com/mernst/beepbeep-3.git --branch nullness
cd beepbeep-3
```

4. Run the Nullness Checker:

```
ant -e check-nullness
```

The output is

```
Buildfile: /home/mernst/java/beepbeep-3-fork-mernst-branch-nullness/build.xml

... [irrelevant lines omitted]

BUILD SUCCESSFUL
Total time: 1 second
```

The lack of error messages (and the correctness of `@SuppressWarnings(nullness)` in the BeepBeep 3 source code) proves that BeepBeep 3 contains no null pointer exceptions.

5. Examine the changes made to BeepBeep 3 to support the Nullness Checker.

https://github.com/liflab/beepbeep-3/compare/master...mernst:beepbeep-3:nullness?expand=1

The Nullness Checker did reveal bugs.  For example, one was fixed here:

https://github.com/liflab/beepbeep-3/pull/75/files
