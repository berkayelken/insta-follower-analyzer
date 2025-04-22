# Instagram Follower Analysis API

This document explains how to download your Instagram follower and following data, and how to use our API to analyze it.

## 📥 How to Download Instagram Data

Follow these steps to download your Instagram **followers** and **following** data:

1. Open the **Instagram app**.
2. Go to your **profile** and tap the **three lines (hamburger) icon** in the top right corner.
3. Select **Accounts Center**.
4. Go to **Your Information and Permissions**.
5. Tap on **Download Your Information**.
6. Tap **Download or Transfer Your Information**, then select **Some of Your Information**.
7. Scroll down and in the **Connections** section, tick **Followers and Following**.
8. Scroll to the bottom and tap **Next**.
9. Change the **file type** from the default **HTML** to **JSON**.
10. Set the **date range** to **All Time**.
11. Tap **Create Files**.
12. You will receive an email from Meta containing a download link for your data.

After downloading, you will need two specific files for our API:
- `following.json`
- `followers_1.json`

## 📊 Using the API

After starting your service, you can send a REST request as follows:

```bash
curl --location 'http://localhost:9876/api/insta/analyze' \
--form 'following=@"/path/to/file/following.json"' \
--form 'followers=@"/path/to/file/followers_1.json"'
