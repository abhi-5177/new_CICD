#!/bin/bash
UserName="abhi-5177"        
Email="abhiptl5177@gmail.com"
Repo="new_CICD"                      
# -----------------------
# Initial Git Setup (only if not already initialized)
# -----------------------
if [ ! -d ".git" ]; then
  echo "🔧 Initializing Git repository..."
  git init
  git branch -M main
  git remote add origin https://github.com/$UserName/$Repo.git
  git config user.name "$UserName"
  git config user.email "$Email"
fi

# -----------------------
# Push test code updates to MAIN branch
# -----------------------
echo "🔄 Pushing local code changes to MAIN branch..."
git add .
git commit -m "Initial commit" || echo "Nothing to commit"
git push origin main

# -----------------------
# Run Maven tests
# -----------------------
echo "🧹 Cleaning old builds..."
mvn clean test

# -----------------------
# Prepare Allure report with history
# -----------------------
echo "📊 Preparing Allure history (for trends)..."
mkdir -p allure-results/history || echo "history folder already exists"
cp -r allure-report/history/* allure-results/history 2>/dev/null || echo "No previous history"

echo "📈 Generating Allure report..."
allure generate allure-results --clean -o allure-report

echo "🕓 Updating history after report..."
cp -r allure-report/history/* allure-results/history || echo "No history to copy"

echo "📄 Generating single HTML Allure report..."
allure generate --single-file allure-results --clean -o allure-report

# -----------------------
# Commit report updates to MAIN
# -----------------------
echo "✅ Committing test and report changes to MAIN branch..."
git add .
git commit -m "Test run and updated Allure report - $(date)" || echo "Nothing to commit"
git push origin main

# -----------------------
# Deploy report to GH-PAGES branch
# -----------------------
echo "🚀 Preparing GH-PAGES branch with single HTML report..."

rm -rf gh-pages
mkdir gh-pages
cp -r allure-report/index.html gh-pages/
cd gh-pages
echo "Allure Report on GitHub Pages" > README.md
touch .nojekyll

echo "🌐 Deploying to gh-pages..."
git init
git checkout -b gh-pages
git remote add origin git@github.com:$UserName/$Repo.git
git config user.name "$UserName"
git config user.email "$Email"
git add .
git commit -m "Deploy Allure report to GitHub Pages - $(date)"
git push --force origin gh-pages

cd ..
rm -rf gh-pages

# -----------------------
# Done
# -----------------------
echo "✅ DONE! Your report is live at:"
echo "➡ https://$UserName.github.io/$Repo/index.html"

#email----------------------------


#!/bin/bash

# Variables
TO_EMAIL="abhiptl5177@gmail.com"
FROM_NAME="QA Bot"
FROM_EMAIL="noreply@example.com"
SUBJECT="✅ Test Report - $(date '+%Y-%m-%d %H:%M')"
REPORT_URL="https://$UserName.github.io/$Repo/index.html"

# Build HTML body
EMAIL_CONTENT=$(cat <<EOF
From: ${FROM_NAME} <${FROM_EMAIL}>
To: ${TO_EMAIL}
Subject: ${SUBJECT}
Content-Type: text/html

<html>
  <body style="font-family: sans-serif; color: #333;">
    <h2>✅ Automated Test Summary</h2>
    <ul>
      <li><strong>Status:</strong> Completed</li>
      <li><strong>Date:</strong> $(date)</li>
      <li><strong>Branch:</strong> main</li>
    </ul>
    <p><strong>Allure Report:</strong> 
      <a href="${REPORT_URL}" target="_blank">View Report</a>
    </p>
    <hr>
    <p>This is an automated email from CI.</p>
  </body>
</html>
EOF
)

# Send Email using sendmail
echo "$EMAIL_CONTENT" | /usr/sbin/sendmail -t



