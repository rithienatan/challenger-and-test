import 'package:flutter/material.dart';
import 'package:flutter/rendering.dart';

class InputPalpite extends StatefulWidget
{
  InputPalpite({Key key}) : super(key: key);

  var palpiteStats = InputPalpiteState();

  @override
  InputPalpiteState createState() => palpiteStats;
}
class InputPalpiteState extends State<InputPalpite>
{
  final reciveUserAnswer = TextEditingController();//get user answer

  void onValueChange()
  {
    setState(() {
      reciveUserAnswer.text;
    });
  }//end onValueChange

  @override
  void initState() {
    super.initState();
    reciveUserAnswer.addListener(onValueChange);
  }
  
  @override
  void dispose()
  {
    reciveUserAnswer.dispose();
    super.dispose();
  }//end dispose()

  //----- build widget -----//
  @override
  Widget build(BuildContext context)
  {
    return Container(
      width: 245.0,
      child: TextField(
        enabled: true,
        controller: reciveUserAnswer,
        maxLength: 3,
        cursorColor: Colors.pinkAccent[400],
        decoration: InputDecoration(
          focusedBorder: UnderlineInputBorder(
            borderSide: BorderSide(color: Colors.pinkAccent[400]),
          ),
          hintText: "Digite o palpite",
          counterText: "${reciveUserAnswer.text.length}/3",
        ),
        keyboardType: TextInputType.number,
      ),
    );
  }//end widget build
}//end class
