import 'package:flutter/material.dart';

class SegmentTop extends StatelessWidget
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
        height: 10.0,
        width: 50.0,
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

    path.lineTo(0, 0);

    //left edge
    path.lineTo(size.width * 0.13, 0);
    path.lineTo(0, size.height * 0.5);
    path.lineTo(size.width * 0.12, size.height);

    path.lineTo(0, size.height);

    //right edge
    path.lineTo(size.width * 0.88, size.height);
    path.lineTo(size.width, size.height * 0.5);
    path.lineTo(size.width * 0.87, 0);

    path.lineTo(size.width, 0);

    path.close();
    return(path);
  }

  @override
  bool shouldReclip(CustomClipper<Path> oldClipper){
    return(oldClipper != this);
  }
}