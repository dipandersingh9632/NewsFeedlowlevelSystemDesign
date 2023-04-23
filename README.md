TO START THE PROGRAM 
1. Go to main and run the program

// Flow:
1. In Main class call the signup() method to create the User
,User will use a **Builder Design Pattern**  to build.
2. call the login() method to login In SessionManager class
we will set the login user so that in all operation login user can access their functions.
3. call the follow() pass the email of followed user now you follow that user.
4. call the post() to post something.
5. same you can call upvote(postId), downvote(postId), reply(postId).
6. you can upvote, downvote, reply on to a comment.
7. you can upvote, downvote, reply on to a subComment.
7. call shownewsfeed("sortingStrategy") shownewsfeed uses **Strategy Design Pattern**  and **Factory Design Pattern** to give you the news post as per your inputs like ("SortByFollowedUsers", "SortByNumComments", "SortByScore", "SortByTimestamp") and you will get the news