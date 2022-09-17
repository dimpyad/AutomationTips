# Setup in Dropbox side
- Signin to dropbox https://www.dropbox.com/
- Open URL https://www.dropbox.com/developers/
- Click on App Console
- Click on Create App
- Enter basic details and create a sample app
- Once app is created successfully click on the App link
- Copy AppKey and AppSecret
- Go to Permissions tab and give permission to files.content.write ,files.content.read, content.write and content.read
- Enter https://oauth.pstmn.io/v1/callback in Redirect URIs and click on Add button
- Allow public clients (Implicit Grant & PKCE) - set as Disallowed

# Setup in Postman
- Create new collection
- Click on the collection and go to **Authorization** tab
- Select type as **Oauth2.0**
- Go down to the **Configuration options**
- Enter Token Name
- Select Grant Type as **Authorization Code**
- Enter https://oauth.pstmn.io/v1/callback as **Callback url**
- Enter https://www.dropbox.com/oauth2/authorize **as Auth url**
- Enter https://www.dropbox.com/oauth2/token as **Access Token URL**
- Enter the AppKey (from dropbox) in **Client ID** (use environment variable)
- Enter the AppSecret (from dropbox) in **Client Secret** (use environment variable)
- Select Send client credential in body in **Client Authentication** dropdown
- Click on **Get New Access Token**

# Demo 
Create folder
- API document link https://www.dropbox.com/developers/documentation/http/documentation#files-create_folder

Upload a file
- API document link - https://www.dropbox.com/developers/documentation/http/documentation#files-upload
