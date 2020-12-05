import 'package:flutter/material.dart';

//----- imports widgets -----//
//import 'InputPalpite.dart';

class ButtonEnviar extends StatefulWidget
{
  String receiveUserText = "here";

  ButtonEnviar({Key key, this.receiveUserText}) : super(key: key);

  var enviarButton = ButtonEnviarState();

  @override
  ButtonEnviarState createState() => enviarButton;
}
class ButtonEnviarState extends State<ButtonEnviar>
{
  @override
  void initState() {
    super.initState();
  }

  //----- build widget -----//
  @override
  Widget build(BuildContext context)
  {
    return RaisedButton(
      onPressed:() {
        setState(() {
          return showDialog(
            context: context,
            builder: (context){
              return AlertDialog(
                content: Text("widget.receiveUserText"),
              );
            }
          );
        });
      },
      child: Text(
        'ENVIAR',
        style: TextStyle(color: Colors.black87),
      ),
    );
  }//end widget build
}//end class