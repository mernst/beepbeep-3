# Evidence that BeepBeep 3 has no resource leaks.

1. Install the Checker Framework:
https://checkerframework.org/manual/#build-source

Note that the instructions include setting the CHECKERFRAMEWORK environment variable.

2. Obtain the BeepBeep 3 source code:

```
git clone https://github.com/mernst/beepbeep-3.git --branch resourceleak
cd beepbeep-3
```

3. Run the Resource Leak Checker:

```
ant -e check-resourceleak
```

The output is

```
Buildfile: /home/mernst/java/beepbeep-3-fork-mernst-branch-resourceleak/build.xml

... [irrelevant lines omitted]

BUILD SUCCESSFUL
Total time: 1 second
```

The lack of error messages in the output console log (and the lack of `@SuppressWarnings("resourceleak")` in the BeepBeep 3 source code) proves that BeepBeep 3 contains no resource leaks.

4. Examine the changes made to BeepBeep 3 to support the Resource Leak Checker.

https://github.com/liflab/beepbeep-3/compare/master...mernst:beepbeep-3:resourceleak?expand=1

No annotations were needed, because BeepBeep 3 does not pass open resources among methods.

The Resource Leak Checker did reveal a resource leak bug on a previous version of BeepBeep 3.  It was fixed in https://github.com/liflab/beepbeep-3/pull/71/files .   The current version of BeepBeep 3 (used in this analysis) has no resource leaks.
