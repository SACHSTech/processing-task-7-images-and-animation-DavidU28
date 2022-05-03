/**
 * A program that loads images of the bikini bottom and spongebob with floating bubbles and boiuncing spongebob
 * @author D. Ursu
 */

import processing.core.PApplet;
import processing.core.PImage;

public class Sketch extends PApplet {

    PImage imgbikiniBottom;
    PImage imgspongebob;

    float fltSpongeBobX = 420;
    float fltSpongeBobY = 500;
    float fltSpongeBobSpeed = 5;
    
    float bubbleY = 680;
    float bubbleX1 = 75;float bubbleX2 = 150;float bubbleX3 = 275; float bubbleX4 = 340;float bubbleX5 = 450;
    float bubbleX6 = 525; float bubbleX7 = 675;float bubbleX8 = 720;float bubbleX9 = 790;float bubbleX10 = 850;
    float bubbleSize1 = random(40,80);float bubbleSize2 = random(40,80);  float bubbleSize3 = random(40,80);float bubbleSize4 = random(40,80);float bubbleSize5 = random(40,80);
    float bubbleSize6 = random(40,80);float bubbleSize7 = random(40,80);float bubbleSize8 = random(40,80);float bubbleSize9 = random(40,80);float bubbleSize10 = random(40,80);
    float speedBubbleY =- 2;
    

  /**
   * Called once at the beginning of execution, put your size all in this method
   */
  public void settings() {
	// put your size call here
    size(900, 680);
	
  }

  /** 
   * Called once at the beginning of execution.  Add initial set up
   * values here i.e background, stroke, fill etc.
   */
  public void setup() {

    // Load Bikini Bottom
    imgbikiniBottom = loadImage("BikiniBottom");
    // Resize Bikini Bottom
    imgbikiniBottom.resize(width, height);
    // Load Sponge Bob
    imgspongebob = loadImage("spongebob.png");
    // Resize Sponge Bob
    imgspongebob.resize(85, 118);
    
  }
    
  /**
   * Called repeatedly, anything drawn to the screen goes here
   */
  public void draw() {

    // Draw Bikini Bottom
    image(imgbikiniBottom, 0, 0);

    // Draw Sponge Bob and move
    image(imgspongebob, fltSpongeBobX, fltSpongeBobY);
    fltSpongeBobX += fltSpongeBobSpeed;

    // Bounce spongebob against edge of screen
    if(fltSpongeBobX < 0 || fltSpongeBobX > 820)
    {
      fltSpongeBobSpeed *= -1;
    }

    // Draw bubbles and move 
    drawbubble(bubbleX1, bubbleY, bubbleSize1);
    drawbubble(bubbleX2, bubbleY - 50, bubbleSize2);
    drawbubble(bubbleX3, bubbleY- 25, bubbleSize3);
    drawbubble(bubbleX4, bubbleY - 10, bubbleSize4);
    drawbubble(bubbleX5, bubbleY, bubbleSize5);
    drawbubble(bubbleX6, bubbleY - 75, bubbleSize6);
    drawbubble(bubbleX7, bubbleY, bubbleSize7);
    drawbubble(bubbleX8, bubbleY - 60, bubbleSize8);
    drawbubble(bubbleX9, bubbleY + 5, bubbleSize9);
    drawbubble(bubbleX10, bubbleY, bubbleSize10);
    float fltwave = (float) (3.14 / 6);
    float speedBubbleY = (float)(Math.sin(fltwave)) * -10;

    bubbleY += speedBubbleY;
   
    bubbleX1 = bubbleX1 + random(-2,2); bubbleX2 = bubbleX2 + random(-2,2); bubbleX3 = bubbleX3 + random(-2,2); bubbleX4 = bubbleX4 + random(-2,2); bubbleX5 = bubbleX5 + random(-2,2);
    bubbleX6 = bubbleX6 + random(-2,2); bubbleX7 = bubbleX7 + random(-2,2); bubbleX8 = bubbleX8 + random(-2,2); bubbleX9 = bubbleX9 + random(-2,2); bubbleX10 = bubbleX10 + random(-2,2);

    // Reset bubbles
    if (bubbleY < 1)
    {
      bubbleY = 680;
    }

  }
  
  /**
   * Draws a bubble based of components of inputed numbers
   * @param bubbleX X position of bubble
   * @param bubbleY y position of bubble
   * @param bubbleSize dimensions of bubble
   */
  public void drawbubble(float bubbleX, float bubbleY, float bubbleSize){
    
    strokeWeight((float) 2.5);
    stroke(100, 255, 255, 100);
    fill(150, 255, 255, 100);
    ellipse(bubbleX,bubbleY,bubbleSize/2,bubbleSize/2);
    noFill();
    stroke(230, 255, 255, 100);
    arc(bubbleX, bubbleY, (float) (bubbleSize / 1.25 / 2), (float) (bubbleSize / 1.25 / 2), (float) (180 / 2), (float) (300 / 2));
    
  }

}
