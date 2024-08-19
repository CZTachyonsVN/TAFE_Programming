
using System.Globalization;

void cout(string s)
{
    Console.WriteLine(s);
}

var date = DateTime.Now;

cout("Setting starting Date Value");
cout("Current Date in Standard Date-Time format: " + date);
cout("Current Date in Date only format: " + date.ToString("dd/MM/yyyy"));
cout("Current Time is: " + date.ToString("hh:mm:ss:fffffff tt"));

int whole = 25;
float flPoint = 30.99f;
double dblPoint = 23.34;

cout($" Numbers: \n whole: {whole} \n float: {flPoint} \n double: {dblPoint}");
cout($" Convert numbers to currency:\n" +
    $" whole: {whole.ToString("C",new CultureInfo("en-AU"))}\n" +
    $" float: {flPoint.ToString("C", new CultureInfo("cs-CZ"))}\n" +
    $" double: {dblPoint.ToString("C", new CultureInfo("vi-VN"))} ");
cout($" string interpolation: int = {whole,10:P} double = {dblPoint,-10:P}");