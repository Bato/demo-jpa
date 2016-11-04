
or create a new repository on the command line

echo "# demo-jpa" >> README.md
git init
git config  --local user.name "Firstname Lastname"
git config --local user.email "me@mail.com"

git add README.md
git commit -m "first commit"
git remote add origin https://github.com/Bato/demo-jpa.git
git push -u origin master
