#!/bin/bash
echo 'Running script'
rm -rf WeApp
mkdir WeApp
git clone https://github.com/CSE201-Group0-Project/WeApp.git
git pull
echo 'Finished cloning'
echo 'All Web Files:'
ls WeApp/*.php
echo 'All SQL Files:'
ls WeApp/*.sql
