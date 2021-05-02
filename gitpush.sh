#!/bin/bash
cd /home/golvik/java_projects/advanced_java/JavaAdvanced
read -p 'textCommit= ' commit_info
git add -A
git commit -a -m"$commit_info"
git push
