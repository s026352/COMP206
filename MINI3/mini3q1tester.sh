#!/bin/bash
# test 1: not divisible & not increasing

G='\033[0;32m'
R='\033[0;31m'
O='\033[0m'
b=$(tput bold)
n=$(tput sgr0)
count=0

echo -e "${b}\n~~~~~~~~~~~~~~~~~~~~~~~~~BEGINNING OF TESTS~~~~~~~~~~~~~~~~~~~~~~~~~~~${n}"
echo -e "${b}TEST 1: 10 5 7\nNot divisible & not increasing${n}"
./divisible <<<"10 5 7"

if [[ $? -eq 3 ]]; then
    echo -e "${G}Correct return code"
    let count=count+1
else
    echo -e "${R}Wrong return code"
fi

echo -e "${O}"

echo -e "${b}TEST 2: 3 6 9\nDivisible & Increasing${n}"
./divisible <<<"3 6 9"

if [[ $? -eq 0 ]]; then
    echo -e "${G}Correct return code"
    let count=count+1
else
    echo -e "${R}Wrong return code"
fi

echo -e "${O}"

echo -e "${b}TEST 3: 5 20 10\nDivisible & not increasing${n}"
./divisible <<<"5 20 10"
if [[ $? -eq 2 ]]; then
    echo -e "${G}Correct return code"
    let count=count+1
else
    echo -e "${R}Wrong return code"
fi
echo -e "${O}"

# EXTRA TA TESTS
echo "==== EXTRA TA TESTS ===="

echo -e "${b}EXTRA TEST 1: 0 5 10\nNot divisible & Increasing${n}"
./divisible <<<"0 5 10"
if [[ $? -eq 1 ]]; then
    echo -e "${G}Correct return code"
    let count=count+1
else
    echo -e "${R}Wrong return code"
fi
echo -e "${O}"

echo -e "${b}EXTRA TEST 2: 3 3 3\nDivisible & not increasing${n}"
./divisible <<<"3 3 3"
if [[ $? -eq 2 ]]; then
    echo -e "${G}Correct return code"
    let count=count+1
else
    echo -e "${R}Wrong return code"
fi
echo -e "${O}"

echo -e "${b}EXTRA TEST 3: 12 9 3\nNot divisible & not increasing${n}"
./divisible <<<"12 9 3"
if [[ $? -eq 3 ]]; then
    echo -e "${G}Correct return code"
    let count=count+1
else
    echo -e "${R}Wrong return code"
fi
echo -e "${O}"

echo -e "${b}EXTRA TEST 4: 3 0 0\nDivisible & not increasing${n}"
./divisible <<<"3 0 0"
if [[ $? -eq 2 ]]; then
    echo -e "${G}Correct return code"
    let count=count+1
else
    echo -e "${R}Wrong return code"
fi
echo -e "${O}"

# negatives test:
echo "==== NEGATIVE TESTS ===="
echo -e "${b}EXTRA TEST 5: -3 -6 -9\nDivisible & Not Increasing${n}"
./divisible <<<"-3 -6 -9"
if [[ $? -eq 2 ]]; then
    echo -e "${G}Correct return code"
    let count=count+1
else
    echo -e "${R}Wrong return code"
fi

echo -e "${O}"
# negatives test:
echo -e "${b}EXTRA TEST 6: -3 6 -9\nDivisible & Not Increasing${n}"
./divisible <<<"-3 6 -9"
if [[ $? -eq 2 ]]; then
    echo -e "${G}Correct return code"
    let count=count+1
else
    echo -e "${R}Wrong return code"
fi

echo -e "${O}"
# negatives test:
echo -e "${b}EXTRA TEST 7: -3 6 9\nDivisible & Increasing${n}"
./divisible <<<"-3 6 9"
if [[ $? -eq 0 ]]; then
    echo -e "${G}Correct return code"
    let count=count+1
else
    echo -e "${R}Wrong return code"
fi

# end of tester
echo -e "${O}${b}~~~~~~~~~~~~~~~~~~~~~~~~~END: $count/10 PASSED~~~~~~~~~~~~~~~~~~~~~~~~~~~\n${n}"