import 'package:flutter/material.dart';

class SegmentLeft extends StatelessWidget
{
  int _setColor = 0xFFEC407A;//change color
  void set setColor(int cor) => _setColor = cor;

  //----- build widget -----//
  @override
  Widget build(BuildContext context)
  {
    return ClipPath(
      clipper: SetEdges(),
      child: Container(
        height: 50.0,
        width: 10.0,
        decoration: BoxDecoration(
          color: Color(_setColor),
        ),
      ),
    );
  }//end widget build
}//end class


class SetEdges extends CustomClipper<Path>{
  @override
  Path getClip(Size size){
    final path = Path();

    path.lineTo(size.width * 0.4, 0);
    path.lineTo(size.width, size.height * 0.1);
    path.lineTo(size.width, size.height * 0.9);
    path.lineTo(size.width * 0.4, size.height);
    path.lineTo(size.width * 0, size.height * 0.87);
    path.lineTo(0, size.height * 0.13);
    path.lineTo(size.width * 0.4, 0);

    path.close();
    return(path);
  }

  @override
  bool shouldReclip(CustomClipper<Path> oldClipper){
    return(oldClipper != this);
  }
}