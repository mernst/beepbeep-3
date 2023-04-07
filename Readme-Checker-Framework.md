# Evidence that BeepBeep 3 has no null pointer exceptions.

1. Install the Checker Framework:
https://checkerframework.org/manual/#build-source .
This step is necessary because BeepBeep uses the Ant build system, which
does not automatically download dependences.

Note that the instructions include setting the CHECKERFRAMEWORK environment variable.

2. Obtain the BeepBeep 3 source code:

```
git clone https://github.com/mernst/beepbeep-3.git --branch nullness
cd beepbeep-3
```

3. Run the Nullness Checker:

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

The lack of error messages in the output console log (and the correctness of `@SuppressWarnings(nullness)` in the BeepBeep 3 source code) proves that BeepBeep 3 contains no null pointer exceptions.

4. Examine the changes made to BeepBeep 3 to support the Nullness Checker.

https://github.com/liflab/beepbeep-3/compare/master...mernst:beepbeep-3:nullness?expand=1

The Nullness Checker did reveal null pointer bugs in a previous version of BeepBeep 3.  For example, one was fixed in https://github.com/liflab/beepbeep-3/pull/75/files .  The current version of BeepBeep 3 (used in this analysis) has no null pointer exceptions.
