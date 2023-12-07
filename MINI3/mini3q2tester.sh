#!/bin/bash
G='\033[0;32m'
R='\033[0;31m'
O='\033[0m'
b=$(tput bold)
n=$(tput sgr0)
count=0

echo -e "${b}\n~~~~~~~~~~~~~~~~~~~~~~~~~BEGINNING OF TESTS~~~~~~~~~~~~~~~~~~~~~~~~~~~${n}"
echo -e "${b}TEST 1: mary ramy\nanagram${n}"
./anagram mary ramy
if [[ $? -eq 0 ]]; then
    echo -e "${G}Correct return code"
    let count=count+1
else
    echo -e "${R}Wrong return code"
fi
echo -e "${O}"

echo -e "${b}TEST 2: bob lary\nnot an anagram${n}"
./anagram bob lary
if [[ $? -eq 1 ]]; then
    echo -e "${G}Correct return code"
    let count=count+1
else
    echo -e "${R}Wrong return code"
fi
echo -e "${O}"

echo -e "${b}TEST 3: bob bobb\nnot an anagram${n}"
./anagram bob bobb
if [[ $? -eq 1 ]]; then
    echo -e "${G}Correct return code"
    let count=count+1
else
    echo -e "${R}Wrong return code"
fi
echo -e "${O}"

echo -e "${b}TEST 4: bobb bob\nnot an anagram${n}"
./anagram bobb bob
if [[ $? -eq 1 ]]; then
    echo -e "${G}Correct return code"
    let count=count+1
else
    echo -e "${R}Wrong return code"
fi
echo -e "${O}"

echo -e "${b}TEST 5: bobb bobb\nanagram${n}"
./anagram bobb bobb
if [[ $? -eq 0 ]]; then
    echo -e "${G}Correct return code"
    let count=count+1
else
    echo -e "${R}Wrong return code"
fi
echo -e "${O}"

echo -e "${b}TEST 6: pOgGers gresgop\nanagram${n} (case insensitive))"
./anagram pOgGers gresgop
if [[ $? -eq 1 ]]; then
    echo -e "${G}Correct return code"
    let count=count+1
else
    echo -e "${R}Wrong return code"
fi
echo -e "${O}"

echo -e "${b}TEST 7: βdsAΩ βdsΩa\nanagram${n} (case insensitive)"
./anagram βdsAΩ βdsΩa
if [[ $? -eq 1 ]]; then
    echo -e "${G}Correct return code"
    let count=count+1
else
    echo -e "${R}Wrong return code"
fi

echo -e "${O}TEST 8: 12 21\nanagram${n}"
./anagram 12 21
if [[ $? -eq 0 ]]; then
    echo -e "${G}Correct return code"
    let count=count+1
else
    echo -e "${R}Wrong return code"
fi

echo -e "${O}TEST 9: 1 123a\nNot an anagram${n}"
./anagram 1 123a
if [[ $? -eq 1 ]]; then
    echo -e "${G}Correct return code"
    let count=count+1
else
    echo -e "${R}Wrong return code"
fi

echo -e
# end of tester
echo -e "${O}${b}~~~~~~~~~~~~~~~~~~~~~~~~~END: $count/9 PASSED~~~~~~~~~~~~~~~~~~~~~~~~~~~\n${n}"
