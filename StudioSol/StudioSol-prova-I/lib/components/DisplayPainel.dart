import 'package:flutter/material.dart';
import 'package:flutter/rendering.dart';

//----- imports segments -----//
import 'SevenSegmentsPainel.dart';

class DisplayPainel extends StatefulWidget
{
  String value;
  DisplayPainel({Key key, this.value}) : super(key : key);

  @override
  DisplayPainelState createState() => DisplayPainelState(value);
}

class DisplayPainelState extends State<DisplayPainel>
{
  String value;
  DisplayPainelState(this.value);

  //for one painel
  GlobalKey<SevenSegmentsPainelState> sevenState = GlobalKey();

  //for two painels
  GlobalKey<SevenSegmentsPainelState> sevenState10 = GlobalKey();
  GlobalKey<SevenSegmentsPainelState> sevenState11 = GlobalKey();

  //for three painels
  GlobalKey<SevenSegmentsPainelState> sevenState20 = GlobalKey();
  GlobalKey<SevenSegmentsPainelState> sevenState21 = GlobalKey();
  GlobalKey<SevenSegmentsPainelState> sevenState22 = GlobalKey();

  void changeValue(String text)
  {
    setState(() {
      value = text;
      if(value.length == 3)
      {
        if((value[0] == "0") && (value[1] == "0"))
        { sevenState.currentState.reset(int.parse(value[2])); }
        else if(value[0] == "0")
        {
          if(sevenState10.currentState != null)
          { sevenState10.currentState.reset(int.parse(value[1])); }
          if(sevenState11.currentState != null)
          { sevenState11.currentState.reset(int.parse(value[2])); }
        }
        else
        {
          if(sevenState20.currentState != null)
          { sevenState20.currentState.reset(int.parse(value[0])); }
          if(sevenState21.currentState != null)
          { sevenState21.currentState.reset(int.parse(value[1])); }
          if(sevenState22.currentState != null)
          { sevenState22.currentState.reset(int.parse(value[2])); }
        }//end if
      }
      else if(value.length == 2)
      {
        if(value[0] == "0")
        { sevenState.currentState.reset(int.parse(value[1])); }
        else
        {
          if(sevenState10.currentState != null)
          { sevenState10.currentState.reset(int.parse(value[0])); }
          if(sevenState11.currentState != null)
          { sevenState11.currentState.reset(int.parse(value[1])); }
        }//end if
      }
      else
      { sevenState.currentState.reset(int.parse(value[0])); }
    });
  }//end changeValue()

  @override
  Widget build(BuildContext context)
  {
    if(value.length == 3)
    {
      if((value[0] == "0") && (value[1] == "0"))
      {
        return Align(
          alignment: Alignment(0, -0.3),
          child: SevenSegmentsPainel(
            key: sevenState,
            number: int.parse(value[2])
          )
        );
      }
      else if(value[0] == "0")
      {
        return Stack(
          children: <Widget>[
            Align(
              alignment: Alignment(-0.25, -0.3),
              child: SevenSegmentsPainel(
                key: sevenState10,
                number: int.parse(value[1]),
              ),
            ),
            Align(
              alignment: Alignment(0.25, -0.3),
              child: SevenSegmentsPainel(
                key: sevenState11,
                number: int.parse(value[2])
              ),
            ),
          ],
        );
      }
      else
      {
        return Stack(
          children: <Widget>[
            Align(
              alignment: Alignment(-0.5, -0.3),
              child: SevenSegmentsPainel(
                key: sevenState20,
                number: int.parse(value[0]),
              ),
            ),
            Align(
              alignment: Alignment(0, -0.3),
              child: SevenSegmentsPainel(
                key: sevenState21,
                number: int.parse(value[1]),
              ),
            ),
            Align(
              alignment: Alignment(0.5, -0.3),
              child: SevenSegmentsPainel(
                key: sevenState22,
                number: int.parse(value[2])
              ),
            ),
          ],
        );
      }//end if
    }
    else if(value.length == 2)
    {
      if(value[0] == "0")
      {
        return Align(
          alignment: Alignment(0, -0.3),
          child: SevenSegmentsPainel(
            key: sevenState,
            number: int.parse(value)
          )
        );
      }
      else
      {
        return Stack(
          children: <Widget>[
            Align(
              alignment: Alignment(-0.25, -0.3),
              child: SevenSegmentsPainel(
                key: sevenState10,
                number: int.parse(value[0])
              ),
            ),
            Align(
              alignment: Alignment(0.25, -0.3),
              child: SevenSegmentsPainel(
                key: sevenState11,
                number: int.parse(value[1])
              ),
            ),
          ],
        );
      }//end if
    }
    else
    {
      return Align(
        alignment: Alignment(0, -0.3),
        child: SevenSegmentsPainel(
          key: sevenState,
          number: int.parse(value[0])
        )
      );
    }//end if
  }//end widget build
}