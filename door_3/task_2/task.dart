import 'dart:io';

class Main {
  final file = File("task.txt");

  bool isDigitAt(String s, int index) {
    return RegExp(r'\d').allMatches(s[index]).isNotEmpty;
  }

  List<String> getAsterisksAroundPosition(List<String> lines, int x, int y) {
    var asterisks = <String>[];

    for (var dX = -1; dX <= 1; dX++) {
      for (var dY = -1; dY <= 1; dY++) {
        if (x + dX >= 0 && x + dX < lines.length && y + dY >= 0 && y + dY < lines.elementAt(x + dX).length) {
          if (lines.elementAt(x + dX)[y + dY] == "*") {
            asterisks.add((x + dX).toString() + ";" + (y + dY).toString());
          }
        }
      }
    }

    return asterisks;
  }

  Map<String, List<int>> getAsterisksWithNumbers(List<String> lines) {
    var asterisks = <String, List<int>>{};

    for (var x = 0; x < lines.length; x++) {
      var line = lines.elementAt(x) + ".";
      var positions = <String>[];
      var number = "";

      for (var y = 0; y < line.length; y++) {
        if (isDigitAt(line, y)) {
          positions.addAll(getAsterisksAroundPosition(lines, x, y));
          number += line[y];
        }

        if (number.isNotEmpty && !isDigitAt(line, y)) {
          for (var position in positions.toSet()) {
            if (asterisks[position] == null) {
              asterisks[position] = <int>[];
            }

            asterisks[position]?.add(int.parse(number));
          }

          number = "";
          positions = <String>[];
        }
      }
    }

    return asterisks;
  }

  List<String> loadFile() {
    return file.readAsLinesSync();
  }
}

void main() {
  var main = Main();

  var result = main
      .getAsterisksWithNumbers(main.loadFile())
      .values
      .where((element) => element.length == 2)
      .map((element) => element.reduce((value, element) => value * element))
      .reduce((value, element) => value + element);

  print(result);
}
