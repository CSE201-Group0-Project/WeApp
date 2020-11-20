## Black Box/System Testing Results
- The search bar is non case-sensitive and works when we type "cHat" and displays all applications with the keyword "chat"
![Alt Text](https://imgur.com/dzZYdLk.gif)
- Applications are displayed correctly on the home page with their icons, names, profiles and prices.
![Alt Text](https://imgur.com/0nrFB6G.gif)
- The “View App” button can be used to take us to the app store to view and download the application.
![Alt Text](https://imgur.com/EyiRpDa.gif)
- The “More Info” button can be used to take us to a page that contains more information about the app 
![Alt Text](https://imgur.com/9sxfn20.gif)
- The sort button can be used to sort applications alphabetically by name 
![Alt Text](https://imgur.com/BjFHAjC.gif)
- The sort button can be used to sort applications by price
![Alt Text](https://imgur.com/GYVfGQu.gif)
- A logged in user can leave a comment on an application 
![Alt Text](https://imgur.com/XSQNU4A.gif)
- A logged in user can leave a fill out a request form for an application 
![Alt Text](https://imgur.com/TLEAonG.gif)
- An admin can access a special tab to view pending application requests
![Alt Text](https://imgur.com/9oFAfUs.gif)
- An admin can delete an application entry
![Alt Text](https://imgur.com/2PEQGem.gif)
- A moderator can delete a comment 
![Alt Text](https://imgur.com/VadfAXb.gif)

## Grey Box Testing Results
- Comments are associated with the correct user nested properly as described in the embedded database 
![Alt Text](https://imgur.com/ynOUK33.gif)
- When an application form does not pass client-side validation, database does not create a new null entry for the application 
![Alt Text](https://imgur.com/LClMFHN.gif)
- When user registration form does not pass client-side validation, database does not create a new null entry for the user 
![Alt Text](https://imgur.com/go3LbHK.gif)

## White Box Testing Results
Class | Test | Passed
--- | --- | --- 
ApplicationRepositoryIntegrationTest | whenFindByName_thenReturnApplications | Yes
ApplicationRepositoryIntegrationTest | whenFindByOrganization_thenReturnApplications | Yes
ApplicationRepositoryIntegrationTest | whenFindByVersion_thenReturnApplications | Yes
ApplicationRepositoryIntegrationTest | whenFindByApproved_thenReturnApplications | Yes
ApplicationRepositoryIntegrationTest | whenFindByCategory_thenReturnApplications | Yes
ApplicationRepositoryIntegrationTest | whenFindByPlatform_thenReturnApplications | Yes
ApplicationRepositoryIntegrationTest | whenFindByUser_thenReturnApplications | Yes
ApplicationRepositoryIntegrationTest | whenFindByKeyword_thenReturnApplications | Yes
ApplicationRepositoryIntegrationTest | whenFindByKeywordForAdmin_thenReturnApplications | Yes
ApplicationRepositoryIntegrationTest | whenFindByOrderByPriceDesc_thenReturnApplications | Yes
ApplicationRepositoryIntegrationTest | whenFindByOrderByNameAsc_thenReturnApplications | Yes
CommentRepositoryIntegrationTest | whenFindByUserId_thenReturnComments| Yes
CommentRepositoryIntegrationTest | whenFindByApplicationId_thenReturnComments | Yes
CommentRepositoryIntegrationTest | whenFindByOrderByCreatedDateDesc_thenReturnComments | Yes
CommentRepositoryIntegrationTest | whenFindByOrderByCreatedDateAsc_thenReturnComments  | Yes
UserRepositoryIntegrationTest | whenFindByUsername_thenReturnUser | Yes
UserRepositoryIntegrationTest | whenFindByName_thenReturnUser | Yes
UserRepositoryIntegrationTest | whenSuccessFullySaveUser | Yes
LoginControllerTest | testGetLogin | Yes
LoginControllerTest | testGetRegister | Yes
LoginControllerTest | testIfAUserCanLoginandLogout | Yes
LoginControllerTest | testInvalidLogin | Yes
ApplicationAdminControllerTest | findAll_ShouldAddAppEntriesToModelAndRenderAppListView | Yes
ApplicationAdminControllerTest | findByKeyword_ShouldAddAppEntriesToModelAndRenderAppListView | Yes
ApplicationAdminControllerTest | testGetApplicationRequest | Yes

![Alt Text](https://imgur.com/Ud8Pbx5.gif)
