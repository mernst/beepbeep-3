# 0. Use Java 8 or 11, because BeepBeep 3 does not compile under Java 17.

# 1. Install the Checker Framework:
https://checkerframework.org/manual/#build-source
# Note that the instructions include setting the CHECKERFRAMEWORK environment variable.

# 2. Obtain the BeepBeep 3 source code:
git clone https://github.com/mernst/beepbeep-3.git --branch resourceleak
cd beepbeep-3

# 3. Run the Resource Leak Checker:
ant -e check-nullness
# The lack of error messages proves that BeepBeep 3 contains no null pointer
# exceptions, except possibly at one of the few bits of code annotated with
# `@SuppressWarnings("nullness")`

