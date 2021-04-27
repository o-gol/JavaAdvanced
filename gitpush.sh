#!/bin/bash
I:
cd I:\2. Java\JavaProjekts\JavaAdvanced
set /p textCommit="commit info:"
echo %textCommit%
git add -A
git commit -a -m"%textCommit%"
