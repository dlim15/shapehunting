Title : Shape Hunting
Authord : Devin Lim
Description : This GUI based project is the Color-Shape hunting game. It has 9 different colors and 3 different shapes.
Your task is to first select the shape that matches with the shape that is spawned on the game board using keyboard.
Colors are changed by specific letters on keyboard and shapes are changed by number 1,2,3 (Non-numpad numbers)

Key for the Shapes are :
  1 : circle
  2 : triangle
  3 : rectangle
Key for the Colors Are :
  a : Ashed Gray
  b : Black
  g : Green
  n : Navy
  r : Red
  s : Sky blue
  t : Tangerine
  v : Violet
  y : Yellow

You notice that the numbers are ordered by number of lines. Since circle has no line, it has lowest value of 1
Since Triangle has 3 lines, placed in 2.
Since Rectangle has 4 lines, placed in 3.
On the other hand, keys for the colors are decided by their first letter.
So, make sure to remember what colors it is being called.
 
Once you type the corresponding letter, you will notice your shape has been changed on the top bar
where it says "Selected Img:". If you successfully choose the matched shape and click that spawned 
shape on the game board, clicked shape will be removed and you will gain a points from it. Gained points will be
displayed on top bar under "Score:". You will notice there is a number inside the SpawnedShape that is decreasing
every second. Once that number goes down to 0, that shape will explode and you will lose the life by one.
So, You should get rid of them before they reaches to 0. Also, there is a penalty when you choose the unmatched
shape or color to where you are clicking. There will be 3 chances of Penalty and once it reaches to 3, 
you will lose the life by one. Thus, make sure to select corresponding shape and color before clicking!

There will be a side bar panel that shows the shape and color chart that kindly illustrates which key each shape
and color is corresponding. So, try to reference them until you get used to shapes and colors.

Each round has a fixed 10 spawned rate. Once you clear all shapes without losing all life,
you will get a pop up message that asks you if you continue to move into the next level.
If you choose "yes" you will be moved into the next level. 
If you choose "no" or click "x" on the popup message, game will be over and you will be moved to game over screen.

If you lose all your life, you will be moved into the gameover screen that asks your information.
Specially to textfields, typed checking has been implemented.
So if you try to type non alphabet letter to your name, it will consume that typed letter with the error message shown
next to the textField.
Same to age. Non-numbers will be filtered out.

Once you filled informations, you will need to click submit in order to save them as a record in txtfile.
If any of textfields left blank, it will not let you submit it and shows the error message next to that textfield.


Program Starting Class : GraphicWindow.java

Features more than required :
1. Used Thread for dynamic program.
2. Dynamic checking on user's input.
3. Using timer that changes the color of the label that changed for a second to let user easily see which
number has been decreased or increased.
4. Using JOptionPane to give program more functionality.
5. Exporting to textfile using user's input.