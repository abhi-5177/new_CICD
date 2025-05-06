#!/bin/bash

TO="abhip2652@gmail.com"
FROM="abhiptl5177@gmail.com"
SUBJECT="✅ Test Report - $(date '+%Y-%m-%d %H:%M')"
REPORT_URL="https://abhi-5177.github.io/new_CICD/index.html"

# Create the email content in a temp file
EMAIL_FILE=$(mktemp)

cat <<EOF > "$EMAIL_FILE"
From: QA Bot <${FROM}>
To: ${TO}
Subject: ${SUBJECT}
MIME-Version: 1.0
Content-Type: text/html

<html>
  <body style="font-family: sans-serif;">
    <h2>✅ Automated Test Summary</h2>
    <ul>
      <li><strong>Status:</strong> Completed</li>
      <li><strong>Date:</strong> $(date)</li>
      <li><strong>Branch:</strong> main</li>
    </ul>
    <p><strong>Allure Report:</strong>
      <a href="${REPORT_URL}" target="_blank">${REPORT_URL}</a>
    </p>
    <hr>
    <p>This is an automated email from CI.</p>
  </body>
</html>
EOF

# Send the email
/usr/sbin/sendmail -t < "$EMAIL_FILE"

# Clean up
rm "$EMAIL_FILE"

echo "✅ Email sent to $TO"
