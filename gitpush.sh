#!/bin/bash
cd /home/golvik/Projects/Java_projects/JavaAdvanced/
read -p 'textCommit= ' commit_info
git add -A
git commit -a -m"$commit_info"
git push
