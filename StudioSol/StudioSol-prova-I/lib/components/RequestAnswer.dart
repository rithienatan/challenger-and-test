import 'dart:async';
import 'dart:convert';
import 'package:http/http.dart' as http;

Future<RequestAnswer> fetchRequest() async
{
  final response = await http.get('https://us-central1-ss-devops.cloudfunctions.net/rand?min=1&max=300');

  if(response.statusCode == 200)
  { return RequestAnswer.fromJSON(json.decode(response.body)); }
  else
  { throw Exception('Erro');}
}//end response

class RequestAnswer
{
  int value;
  var futureRequest = fetchRequest();//made request

  RequestAnswer({this.value});

  factory RequestAnswer.fromJSON(Map<String, dynamic> json)
  {
    return RequestAnswer(
      value: json['value'],
    );
  }//end factory
}//end class