A view on the project:

It has total 45 .java files(Including controllers) and 35 .fxml files and 5 .css files. Used two databse- user and playlist.
css used for font size, style, scrollbar, and choicebox.
Every category has a borderpane where they load their sections and subsections.
Every URL is used in the app is HTTPS address and uses the default browser of the desktop.
Every icon is png file downloaded from https://www.flaticon.com/
Background images are created in photoshop and images used in nutriments (diet plan, restrictions, and special care in 'Nutriments') are
created in PowerPoint.

**Categories, sections and subcategories:**

1. Food & Nutrition:
 
This catagory depends mostly on the database. It has 4 sections-
i. Nutritional Status: A calculator to know weight status, daily needs of calories, and protein. Calculated data is used to make a diet
plan.
ii. Nutriment: Diet plan with cautions according to the child's weight status. 
->Subsection: Diet chart. Loads images and icons according to the given data by the user.
iii. Recipes: A list of shared youtube contents about the child's meal mentioned in the diet plan. Unchangeable.

2. Reminder & Notifications: A user-dependent catagory. It has 2 sections-

i. Vaccine Reminder: User can save a reminder here, an email will be sent on a given date and time as the user wanted. Quartz scheduler
was used to create a thread in the background to send the email in the required time.
ii. Pop-ups: Users can save a reminder with a message body. Works as same as 'Vaccine Reminder'.
Both of them are a bit time-consuming.

3. Growth & Immunity: Default. Can't be changed, also it doesn't depend on the database. It has 5 sections-

i. Care Playlist: A list of shared youtube contents about child care. Unchangeable.
ii. Care Blogs: A list of shared websites about child care. Unchangeable.
iii. Growth Charts: A list of pdfs about child growth and surveys that are stored in a google drive account. Unchangeable.
iv. Growth Calculator: Calculates certain data to learn about a child's growth and development.
v. Autism: Websites and blogs about childhood autism shared as hyperlinks.

4. Edu-corner: This is the only category that children can use directly. It has 4 sections-

i. Fun and Learn: A list of shared youtube contents that are made for kids. Unchangeable.
ii. Book corner: A list of pdfs of short and easy stories made for kids that are stored in a google drive account. Unchangeable.
iii. Quiz: More likely a variety of tests on various topics for kids. Questions are generated randomly. There is a result page with comment according to the achieved score after the quiz is taken.
->Subsections: Mainly the quiz questioning method, like fill in the blanks, multiple choices, select the correct image, write the correct answer.
iv. Create Playlist: Save up to 10 web addresses (youtube or any other address), the user may change the list. MySQL database is used to save the list.

**User settings:**
1. Email can't be changed.
2. Must provide the user's child's birthday, weight status(or calculate in the app if they don't know), gender. MySQL database is used to save the values.
3. Several accounts with distinct email can be created in one desktop.

**Changes made:**
Controller classes are named after the functions of certain buttons or pages. However, there were some changes, and controller classes have different names. So here is a list of which controller class controls what:-

GetbmiController => Food & Nutrition(Category 1)
FunListController => Edu-corner(Category 4)
FoodChartController => Growth & Immunity(Category 3)
CareCorner => Care Playlist(Section i of Category 3)
CareArticle => Care Blogs(Section ii of Category 3)
