# 1. Install the Checker Framework:
https://checkerframework.org/manual/#build-source
# Note that the instructions include setting the CHECKERFRAMEWORK environment variable.

# 2. Obtain the BeepBeep 3 source code:
git clone https://github.com/mernst/beepbeep-3.git --branch resourceleak
cd beepbeep-3

# 3. Run the Resource Leak Checker:
ant -e check-resourceleak
# The lack of error messages proves that BeepBeep 3 contains no resource leaks.

