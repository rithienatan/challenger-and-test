import 'package:flutter/material.dart';
import 'package:flutter/rendering.dart';


class LabelInfo extends StatefulWidget
{
  String textInfo;
  LabelInfo({Key key, this.textInfo}) : super(key : key);

  @override
  LabelInfoState createState() => LabelInfoState(textInfo);
}

class LabelInfoState extends State<LabelInfo>
{
  String value;
  LabelInfoState(this.value);

  void changeValue(String change)
  {
    setState(() {
      value = change;
    });
  }

  //----- build widget -----//
  @override
  Widget build(BuildContext context)
  {
    return Container(
      child: Text(
        value,
        style: TextStyle(fontSize: 15)
      )
    );
  }//end widget build
}//end class