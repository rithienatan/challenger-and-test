/**
 * @author Rithie Natan Carvalhaes Prado
 * @email rithienatan@gmail.com
 * @version 1.0.0 - stable
 * Latest Update - 06/08/2020
 * 
 * Descrição da resolução da prova:
 * 1º Todas as estruturas estão no formato de Programação Orientada a Objeto (POO).
 * 2º O http request feito através da classe 'RequestAnswer.dart'. Consiste em fazer uma requisição GET
 *    para o servidor onde contém a solução do jogo, decodificar o arquivo JSON e inserir no atributo da classe.
 * 3º As classes 'main.dart', 'ButtonEnviar.dart', 'DisplayPainel.dart', 'SevenSegmentsPainel.dart',
 *    'LabelInfo.dart' extendem um widget do tipo Stateful, no qual sofrem alterações de acordo com a interação 
 *    que o usuário tem com o aplicativo.
 * 4º 'InputPalpite.dart': representa o widget para input de palpites referente ao jogo.
 * 5º 'ButtonEnviar.dart': representa o widget para a confirmação do palpite digitado pelo usuário.
 * 6º 'LabelInfo.dart': representa o widget para as informações que dizem respeito ao palpite do usuário e 
 *    a resposta correta.
 * 7º 'DisplayPainel.dart': representa os paineis de leds da solução. É através desta classe que definimos a
 *    quantidade de paineis serão mostrados no aplicativo.
 * 8º 'SevenSegmentsPainel.dart': constroi um painel de led dentro de um container. Para isso são utilizadas as
 *    classes 'SegmentBottom.dart'(led inferior), 'SegmentLeft.dart'(leds esquerdos),
 *    'SegmentMiddle.dart'(led localizado ao meio), 'SegmentRight.dart'(leds direitos) e 
 *    'SegmentTop.dart'(led superior). Valido resaltar que cada pedaço do led é desenhado por as classes 
 *    'SegmentsTop/Middle/Bottom/Left/Right.dart'.
 * 9º Ao usuário inserir a resposta correta, um botão com o nome 'Nova Partida' será mostrado na tela.
 * 10º O setup para o botão 'NovaPartida' é representado pela classe PlayAgain no arquivo 'main.dart', no qual
 *     após ser clicado, sua função reinicia o aplicativo.
 * 11º Para o erro de requisição, os componentes são setados fixamente no arquivo 'main.dart'.
 * 12º A classe 'SevenSegmentsPainel.dart' também é resposável por construir os números de cada led separadamente.
 */


//---------------------- Main Imports ----------------------//
import 'package:flutter/material.dart';
import 'package:flutter/rendering.dart';

//----- imports widgets -----//
import 'components/LabelInfo.dart';
import 'components/InputPalpite.dart';
import 'components/SevenSegmentsPainel.dart';
import 'components/RequestAnswer.dart';
import 'components/DisplayPainel.dart';

/**
 * Metodo main
 */
void main() 
{
  runApp(
    PlayAgain(
      child: MyApp(),
    )
  );
}//end main()

//---------------------- PlayAgain Widgets ----------------------//
/**
 * Widget play again
 */
class PlayAgain extends StatefulWidget
{
  PlayAgain({this.child});

  final Widget child;

  static void playAgain(BuildContext context)
  { context.findAncestorStateOfType<PlayAgainState>().playAgain(); }

  @override
  PlayAgainState createState() => PlayAgainState();
}//end class

class PlayAgainState extends State<PlayAgain>
{
  Key key = UniqueKey();

  void playAgain()
  {
    setState(() {
      key = UniqueKey();
    });
  }//end playAgain()

  @override
  Widget build(BuildContext context)
  {
    return KeyedSubtree(
      key: key,
      child: widget.child,
    );
  }//end widget build
}//end class

//---------------------- App Widgets ----------------------//
/**
 * Widget class
 */
class MyApp extends StatefulWidget
{
  const MyApp({Key key}) : super(key: key);

  @override
  MyAppState createState() => MyAppState();
}
class MyAppState extends State<MyApp> {
  //----- set global keys -----
  GlobalKey<InputPalpiteState> palpite = GlobalKey();
  GlobalKey<SevenSegmentsPainelState> sevenSegments = GlobalKey();
  GlobalKey<LabelInfoState> info = GlobalKey();
  GlobalKey<DisplayPainelState> display = GlobalKey();

  Future<RequestAnswer> futureRequest;

  bool showButton = false;
  bool isButtonDisable;

  @override
  void initState()
  {
    super.initState();
    futureRequest = fetchRequest();
    isButtonDisable = false;
  }//end initState()

  void disableButton()
  {
    setState(() {
      isButtonDisable = true;
    });
  }

  @override
  void dispose() {
    super.dispose();
  }//end dispose()

  double slideValue = 100;

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'Studio Sol - test estágio',
      home: Scaffold(
        appBar: AppBar(
          title: Text('Qual é o número?'),
          actions: <Widget>[
            IconButton(
              icon: Icon( Icons.format_size ), 
              onPressed: () {
                setState(() {
                  return Slider(
                    min: 50,
                    max: 100,
                    divisions: 5,
                    value: slideValue, 
                    label: slideValue.round().toString(),
                    onChanged: (double value) {
                      setState(() {
                        slideValue = value;
                      });
                    },
                  );
                });
              }
            ),
            IconButton(
              icon: Icon( Icons.palette ), 
              onPressed: () {

              }
            ),
          ],
          backgroundColor: Colors.pinkAccent[400]
        ),
        body: Center(
          child: FutureBuilder<RequestAnswer>(
            future: futureRequest,
            builder: (context, snapshot){
              if(snapshot.hasData)
              { 
                return(
                  Stack(
                    children: <Widget>[
                      Align(
                        alignment: Alignment(0, -0.5),
                        child: LabelInfo( key: info, textInfo: "" ),//label information
                      ),
                      DisplayPainel(
                        key: display,
                        value: "0",//palpite.currentState.reciveUserAnswer.text,
                      ),
                      Visibility(
                        visible: showButton,
                        child: Align(
                          alignment: Alignment(0, 0.1),
                          child: RaisedButton(
                            onPressed: () { PlayAgain.playAgain(context); },
                            child: Text(
                              'Nova Partida',
                              style: TextStyle(color: Colors.black87),
                            ),
                          ),//button 'Nova Partida'
                        ),
                      ),
                      Align(
                        alignment: Alignment(-0.9, 0.98),
                        child: InputPalpite( key: palpite ),//InputTextField números
                      ),
                      Align(
                        alignment: Alignment(0.9, 0.9),
                        child: RaisedButton(
                          onPressed: isButtonDisable ? null : (){
                            setState(() {
                              if(palpite.currentState.reciveUserAnswer.text.contains(" ") == true ||
                                 palpite.currentState.reciveUserAnswer.text.contains(",") == true ||
                                 palpite.currentState.reciveUserAnswer.text.contains(".") == true ||
                                 palpite.currentState.reciveUserAnswer.text.contains("-") == true ||
                                 int.parse(palpite.currentState.reciveUserAnswer.text) > 300)
                              {
                                return showDialog(
                                  context: context,
                                  builder: (context){
                                      return AlertDialog(
                                        content: Text("Deve conter números entre 1 e 300!"),
                                      );
                                  }
                                );
                              }
                              else
                              {
                                if(int.parse(palpite.currentState.reciveUserAnswer.text) > snapshot.data.value)
                                { 
                                  info.currentState.changeValue("É menor");
                                  display.currentState.changeValue(palpite.currentState.reciveUserAnswer.text);
                                }
                                else if(int.parse(palpite.currentState.reciveUserAnswer.text) < snapshot.data.value)
                                { 
                                  info.currentState.changeValue("É maior");
                                  display.currentState.changeValue(palpite.currentState.reciveUserAnswer.text);
                                }
                                else
                                { 
                                  info.currentState.changeValue("Acertou!");
                                  display.currentState.changeValue(palpite.currentState.reciveUserAnswer.text);
                                  showButton = true;
                                  disableButton();
                                }//end if
                              }//end if
                            });
                          },
                          child: Text(
                            'ENVIAR',
                            style: TextStyle(color: Colors.black87),
                          ),
                        ),
                      ),
                    ],
                  )
                );
              }
              else if(snapshot.hasError)//App stats and layout, when receives error by http(get)
              { 
                return(
                  Stack(
                    children: [
                      Align(
                        alignment: Alignment(0, -0.5),
                        child: LabelInfo( textInfo: "Erro"),//label information
                      ),
                      Align(
                        alignment: Alignment(-0.5, -0.3),
                        child: SevenSegmentsPainel(number: 5),//painel
                      ),
                      Align(
                        alignment: Alignment(0, -0.3),
                        child: SevenSegmentsPainel(number: 0),//painel
                      ),
                      Align(
                        alignment: Alignment(0.5, -0.3),
                        child: SevenSegmentsPainel(number: 2),//painel
                      ),
                      Align(
                        alignment: Alignment(0, 0.1),
                        child: RaisedButton(
                          onPressed: () { PlayAgain.playAgain(context); },
                          child: Text(
                            'Nova Partida',
                            style: TextStyle(color: Colors.black87),
                          ),
                        ),//button 'Nova Partida'
                      ),
                      Align(
                        alignment: Alignment(-0.9, 0.98),
                        child: Container(//InputTextField disabled
                          width: 245.0,
                          child: TextField(
                            enabled: false,
                            decoration: InputDecoration(
                              hintText: "Digite o palpite",
                              counterText: "0/3",
                            ),
                          ),
                        ),
                      ),
                      Align(
                        alignment: Alignment(0.9, 0.9),
                        child: RaisedButton(
                          onPressed: null,
                          child: Text(
                            'ENVIAR',
                            style: TextStyle(color: Colors.black87),
                          ),
                        ), //receiveUserText: palpite.currentState.userText),//button 'ENVIAR'//receiveUserText: palpite.currentState.userText),//button 'ENVIAR'
                      ),
                    ],
                  )
                ); 
              }//end if

              return CircularProgressIndicator();
            },
          ),
        ),
      ),
    );
  }
}//end class