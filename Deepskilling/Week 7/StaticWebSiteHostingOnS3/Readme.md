# 🚀 AWS Static Website Hosting using Amazon S3

This guide explains how to host a static website on AWS S3 in a simple and easy-to-follow manner.

---

# 📌 Architecture

```text
                +------------------+
                |     User         |
                |  (Web Browser)   |
                +--------+---------+
                         |
                         | HTTP Request
                         ▼
              +----------------------+
              |      Amazon S3       |
              | Static Website Bucket|
              +----------+-----------+
                         |
                         |
              +----------▼-----------+
              |   HTML / CSS / JS    |
              |   Static Website     |
              +----------------------+
```

---

# 📋 Prerequisites

- AWS Account
- Static website files
  - `index.html`
  - `style.css`
  - `script.js`
  - Images (optional)

---

# Step 1: Login to AWS Console

1. Open AWS Management Console.
2. Search for **S3**.
3. Click **Amazon S3**.

---

# Step 2: Create an S3 Bucket

1. Click **Create bucket**.
2. Enter a unique bucket name.
3. Select your preferred AWS Region.
4. Uncheck:

```
Block all public access
```

5. Acknowledge the warning.
6. Click **Create bucket**.

---

## Diagram

```text
AWS Console
      │
      ▼
Amazon S3
      │
      ▼
Create Bucket
      │
      ▼
Bucket Created
```

---

# Step 3: Upload Website Files

Open your bucket.

Click

```
Upload
```

Upload all website files.

Example:

```
index.html
style.css
script.js
images/
```

Click **Upload**.

---

## Diagram

```text
Local Computer
      │
      ▼
Website Files
      │
      ▼
Upload to S3 Bucket
```

---

# Step 4: Enable Static Website Hosting

Inside the bucket:

```
Properties
      │
      ▼
Static Website Hosting
```

Click

```
Edit
```

Choose

```
Enable
```

Enter

```
Index document:
index.html
```

(Optional)

```
Error document:
error.html
```

Save changes.

---

## Diagram

```text
Bucket
   │
   ▼
Properties
   │
   ▼
Static Website Hosting
   │
   ▼
Enabled
```

---

# Step 5: Configure Bucket Policy

Go to

```
Permissions
```

Click

```
Bucket Policy
```

Paste the following policy.

Replace:

```
YOUR_BUCKET_NAME
```

with your bucket name.

```json
{
  "Version": "2012-10-17",
  "Statement": [
    {
      "Sid": "PublicRead",
      "Effect": "Allow",
      "Principal": "*",
      "Action": "s3:GetObject",
      "Resource": "arn:aws:s3:::YOUR_BUCKET_NAME/*"
    }
  ]
}
```

Save the policy.

---

## Diagram

```text
Bucket
   │
   ▼
Permissions
   │
   ▼
Bucket Policy
   │
   ▼
Public Read Access
```

---

# Step 6: Verify Public Access

Ensure:

- Block Public Access → Disabled
- Bucket Policy → Added
- Objects are publicly accessible

---

# Step 7: Access the Website

Go to

```
Properties
      │
      ▼
Static Website Hosting
```

Copy the

```
Bucket Website Endpoint
```

Example

```
http://your-bucket-name.s3-website-us-east-1.amazonaws.com
```

Open it in your browser.

---

## Diagram

```text
Browser
   │
   ▼
Website Endpoint
   │
   ▼
Amazon S3
   │
   ▼
index.html
   │
   ▼
Website Loaded
```

---

# Complete Flow

```text
          Create Bucket
                 │
                 ▼
      Disable Public Block
                 │
                 ▼
        Upload Website Files
                 │
                 ▼
 Enable Static Website Hosting
                 │
                 ▼
       Add Bucket Policy
                 │
                 ▼
      Get Website Endpoint
                 │
                 ▼
         Access Website
```

---

# Folder Structure

```text
website/
│
├── index.html
├── style.css
├── script.js
├── error.html
└── images/
    ├── logo.png
    └── banner.jpg
```

---

# Best Practices

- Keep `index.html` in the root folder.
- Use meaningful file names.
- Enable versioning (recommended).
- Use CloudFront for HTTPS and faster delivery.
- Use Route 53 for custom domains.
- Store only static content in S3.

---

# Optional Production Architecture

```text
                    User
                      │
                      ▼
               Route 53 (DNS)
                      │
                      ▼
             AWS CloudFront CDN
                      │
                      ▼
              Amazon S3 Bucket
                      │
                      ▼
            HTML • CSS • JS • Images
```

---

# Troubleshooting

| Issue | Solution |
|-------|----------|
| Access Denied | Check Bucket Policy |
| 403 Forbidden | Disable Block Public Access |
| 404 Error | Verify `index.html` exists |
| CSS/JS not loading | Check file paths |
| Website not opening | Verify Static Website Hosting is enabled |

---

# AWS Services Used

- Amazon S3
- IAM (Permissions)
- Bucket Policy
- Static Website Hosting
- *(Optional)* CloudFront
- *(Optional)* Route 53

---

# Conclusion

You have successfully hosted a static website on AWS S3.

Workflow Summary:

```text
Create Bucket
      │
      ▼
Upload Files
      │
      ▼
Enable Static Hosting
      │
      ▼
Configure Bucket Policy
      │
      ▼
Get Website Endpoint
      │
      ▼
Website Live 🎉
```