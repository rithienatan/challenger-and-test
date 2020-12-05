import 'package:flutter/material.dart';
import 'package:flutter/rendering.dart';

//----- imports segments -----//
import 'SegmentTop.dart';
import 'SegmentMiddle.dart';
import 'SegmentBottom.dart';
import 'SegmentLeft.dart';
import 'SegmentRight.dart';

class SevenSegmentsPainel extends StatefulWidget
{
  SevenSegmentsPainel({Key key, this.number}) : super(key : key);

  int number;

  @override
  SevenSegmentsPainelState createState() => SevenSegmentsPainelState(number);
}//end class

class SevenSegmentsPainelState extends State<SevenSegmentsPainel>
{
  final int pinkAccentColor = 0xFFEC407A;//main color
  final int greyColor = 0xFFEEEEEE;//disable color

  int number;//initial number = 0
  SevenSegmentsPainelState(this.number);

  void reset(int numero)
  {
    setState(() {
      number = numero;
    });
  }

  @override
  void dispose() {
    super.dispose();
  }//end dispose()

  //----- build widget -----//
  @override
  Widget build(BuildContext context)
  {
    var top = SegmentTop();
    var bottom = SegmentBottom();
    var middle = SegmentMiddle();
    var left1 = SegmentLeft();
    var left2 = SegmentLeft();
    var right1 = SegmentRight();
    var right2 = SegmentRight();

    if(number == 1)//number 1
    {
      top.setColor = greyColor;
      left1.setColor = greyColor;
      left2.setColor = greyColor;
      middle.setColor = greyColor;
      bottom.setColor = greyColor;

      return Container(
        height: 120.0,
        width: 100.0,
        /*
        decoration: BoxDecoration(
          color: Colors.black,
        ),
        */
        child: Stack(
          children: [
            Align(
              alignment: Alignment(0, -0.98),
              child: top,
            ),
            Align(
              alignment: Alignment(-0.55, -0.8),
              child: left1,
            ),
            Align(
              alignment: Alignment(-0.55, 0.65),
              child: left2,
            ),
            Align(
              alignment: Alignment(0, 0.88),
              child: bottom,
            ),
            Align(
              alignment: Alignment(0.55, 0.65),
              child: right1,
            ),
            Align(
              alignment: Alignment(0.55, -0.8),
              child: right2,
            ),
            Align(
              alignment: Alignment(0, -0.05),
              child: middle,
            ),
          ],
        ),
      );
    }
    else if(number == 2)//number 2
    {
      left1.setColor = greyColor;
      right1.setColor = greyColor;

      return Container(
        height: 120.0,
        width: 100.0,
        /*
        decoration: BoxDecoration(
          color: Colors.black,
        ),
        */
        child: Stack(
          children: [
            Align(
              alignment: Alignment(0, -0.98),
              child: top,
            ),
            Align(
              alignment: Alignment(-0.55, -0.8),
              child: left1,
            ),
            Align(
              alignment: Alignment(-0.55, 0.65),
              child: left2,
            ),
            Align(
              alignment: Alignment(0, 0.88),
              child: bottom,
            ),
            Align(
              alignment: Alignment(0.55, 0.65),
              child: right1,
            ),
            Align(
              alignment: Alignment(0.55, -0.8),
              child: right2,
            ),
            Align(
              alignment: Alignment(0, -0.05),
              child: middle,
            ),
          ],
        ),
      );
    }
    else if(number == 3)//number 3
    {
      left1.setColor = greyColor;
      left2.setColor = greyColor;

      return Container(
        height: 120.0,
        width: 100.0,
        /*
        decoration: BoxDecoration(
          color: Colors.black,
        ),
        */
        child: Stack(
          children: [
            Align(
              alignment: Alignment(0, -0.98),
              child: top,
            ),
            Align(
              alignment: Alignment(-0.55, -0.8),
              child: left1,
            ),
            Align(
              alignment: Alignment(-0.55, 0.65),
              child: left2,
            ),
            Align(
              alignment: Alignment(0, 0.88),
              child: bottom,
            ),
            Align(
              alignment: Alignment(0.55, 0.65),
              child: right1,
            ),
            Align(
              alignment: Alignment(0.55, -0.8),
              child: right2,
            ),
            Align(
              alignment: Alignment(0, -0.05),
              child: middle,
            ),
          ],
        ),
      );
    }
    else if(number == 4)//number 4
    {
      top.setColor = greyColor;
      bottom.setColor = greyColor;
      left2.setColor = greyColor;

      return Container(
        height: 120.0,
        width: 100.0,
        /*
        decoration: BoxDecoration(
          color: Colors.black,
        ),
        */
        child: Stack(
          children: [
            Align(
              alignment: Alignment(0, -0.98),
              child: top,
            ),
            Align(
              alignment: Alignment(-0.55, -0.8),
              child: left1,
            ),
            Align(
              alignment: Alignment(-0.55, 0.65),
              child: left2,
            ),
            Align(
              alignment: Alignment(0, 0.88),
              child: bottom,
            ),
            Align(
              alignment: Alignment(0.55, 0.65),
              child: right1,
            ),
            Align(
              alignment: Alignment(0.55, -0.8),
              child: right2,
            ),
            Align(
              alignment: Alignment(0, -0.05),
              child: middle,
            ),
          ],
        ),
      );
    }
    else if(number == 5)//number 5
    {
      left2.setColor = greyColor;
      right2.setColor = greyColor;

      return Container(
        height: 120.0,
        width: 100.0,
        /*
        decoration: BoxDecoration(
          color: Colors.black,
        ),
        */
        child: Stack(
          children: [
            Align(
              alignment: Alignment(0, -0.98),
              child: top,
            ),
            Align(
              alignment: Alignment(-0.55, -0.8),
              child: left1,
            ),
            Align(
              alignment: Alignment(-0.55, 0.65),
              child: left2,
            ),
            Align(
              alignment: Alignment(0, 0.88),
              child: bottom,
            ),
            Align(
              alignment: Alignment(0.55, 0.65),
              child: right1,
            ),
            Align(
              alignment: Alignment(0.55, -0.8),
              child: right2,
            ),
            Align(
              alignment: Alignment(0, -0.05),
              child: middle,
            ),
          ],
        ),
      );
    }
    else if(number == 6)//number 6
    {
      right2.setColor = greyColor;

      return Container(
        height: 120.0,
        width: 100.0,
        /*
        decoration: BoxDecoration(
          color: Colors.black,
        ),
        */
        child: Stack(
          children: [
            Align(
              alignment: Alignment(0, -0.98),
              child: top,
            ),
            Align(
              alignment: Alignment(-0.55, -0.8),
              child: left1,
            ),
            Align(
              alignment: Alignment(-0.55, 0.65),
              child: left2,
            ),
            Align(
              alignment: Alignment(0, 0.88),
              child: bottom,
            ),
            Align(
              alignment: Alignment(0.55, 0.65),
              child: right1,
            ),
            Align(
              alignment: Alignment(0.55, -0.8),
              child: right2,
            ),
            Align(
              alignment: Alignment(0, -0.05),
              child: middle,
            ),
          ],
        ),
      );    
    }
    else if(number == 7)//number 7
    {
      left1.setColor = greyColor;
      left2.setColor = greyColor;
      middle.setColor = greyColor;
      bottom.setColor = greyColor;

      return Container(
        height: 120.0,
        width: 100.0,
        /*
        decoration: BoxDecoration(
          color: Colors.black,
        ),
        */
        child: Stack(
          children: [
            Align(
              alignment: Alignment(0, -0.98),
              child: top,
            ),
            Align(
              alignment: Alignment(-0.55, -0.8),
              child: left1,
            ),
            Align(
              alignment: Alignment(-0.55, 0.65),
              child: left2,
            ),
            Align(
              alignment: Alignment(0, 0.88),
              child: bottom,
            ),
            Align(
              alignment: Alignment(0.55, 0.65),
              child: right1,
            ),
            Align(
              alignment: Alignment(0.55, -0.8),
              child: right2,
            ),
            Align(
              alignment: Alignment(0, -0.05),
              child: middle,
            ),
          ],
        ),
      );  
    }
    else if(number == 8)//number 8
    {
      return Container(
        height: 120.0,
        width: 100.0,
        /*
        decoration: BoxDecoration(
          color: Colors.black,
        ),
        */
        child: Stack(
          children: [
            Align(
              alignment: Alignment(0, -0.98),
              child: top,
            ),
            Align(
              alignment: Alignment(-0.55, -0.8),
              child: left1,
            ),
            Align(
              alignment: Alignment(-0.55, 0.65),
              child: left2,
            ),
            Align(
              alignment: Alignment(0, 0.88),
              child: bottom,
            ),
            Align(
              alignment: Alignment(0.55, 0.65),
              child: right1,
            ),
            Align(
              alignment: Alignment(0.55, -0.8),
              child: right2,
            ),
            Align(
              alignment: Alignment(0, -0.05),
              child: middle,
            ),
          ],
        ),
      ); 
    }
    else if(number == 9)//number 9
    {
      left2.setColor = greyColor;

      return Container(
        height: 120.0,
        width: 100.0,
        /*
        decoration: BoxDecoration(
          color: Colors.black,
        ),
        */
        child: Stack(
          children: [
            Align(
              alignment: Alignment(0, -0.98),
              child: top,
            ),
            Align(
              alignment: Alignment(-0.55, -0.8),
              child: left1,
            ),
            Align(
              alignment: Alignment(-0.55, 0.65),
              child: left2,
            ),
            Align(
              alignment: Alignment(0, 0.88),
              child: bottom,
            ),
            Align(
              alignment: Alignment(0.55, 0.65),
              child: right1,
            ),
            Align(
              alignment: Alignment(0.55, -0.8),
              child: right2,
            ),
            Align(
              alignment: Alignment(0, -0.05),
              child: middle,
            ),
          ],
        ),
      );   
    }
    else if(number == 0)//number 0
    {
      middle.setColor = greyColor;

      return Container(
        height: 120.0,
        width: 100.0,
        /*
        decoration: BoxDecoration(
          color: Colors.black,
        ),
        */
        child: Stack(
          children: [
            Align(
              alignment: Alignment(0, -0.98),
              child: top,
            ),
            Align(
              alignment: Alignment(-0.55, -0.8),
              child: left1,
            ),
            Align(
              alignment: Alignment(-0.55, 0.65),
              child: left2,
            ),
            Align(
              alignment: Alignment(0, 0.88),
              child: bottom,
            ),
            Align(
              alignment: Alignment(0.55, 0.65),
              child: right1,
            ),
            Align(
              alignment: Alignment(0.55, -0.8),
              child: right2,
            ),
            Align(
              alignment: Alignment(0, -0.05),
              child: middle,
            ),
          ],
        ),
      );
    }
    else
    {
      return Container(
        height: 120.0,
        width: 100.0,
        /*
        decoration: BoxDecoration(
          color: Colors.black,
        ),
        */
        child: Text( "Error !" ),
      );
    }//end if
  }//end widget build
}//end class