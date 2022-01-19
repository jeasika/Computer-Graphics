/*
**
*** Code made with help of some examples from Processing.org
**** and by Jeasika López
*/

//Variables
color a, b, c, d, e;
int barWidth = 20;
int lastBar = -1;

void setup() {
  size(600, 400);
  noStroke();
  //Define colors
  a = color(255, 160, 122);
  b = color(255, 127, 80);
  c = color(255, 99, 71);
  d = color(205, 92, 92);
  e = color(178, 34, 34);
}

void draw() {
  //Backgorund colors
  drawBand(a, b, c, d, e, 0, width/80);
  drawBand(c, a, d, b, e, height/2, width/80);
  //square follows mouse
  square(mouseX, mouseY, 10);
  //changes color when mouse is over
  int whichBar = mouseX / barWidth;
  if (whichBar != lastBar) {
    int barX = whichBar * barWidth;
    fill(mouseY, height, height);
    rect(barX, 0, barWidth, height);
    lastBar = whichBar;
  }
}

//Division of colors for the background
void drawBand(color v, color w, color x, color y, color z, int ypos, int barWidth) {
  int num = 5;
  color[] colorOrder = { v, w, x, y, z };
  for(int i = 0; i < width; i += barWidth*num) {
    for(int j = 0; j < num; j++) {
      fill(colorOrder[j]);
      rect(i+j*barWidth, ypos, barWidth, height/2);
    }
  }
}
