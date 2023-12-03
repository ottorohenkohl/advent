import 'dart:io';

class Main {
  final file = File("task.txt");

  bool isDigitAt(String s, int index) {
    return RegExp(r'\d').allMatches(s[index]).isNotEmpty;
  }

  bool isValidAt(List<String> lines, int x, int y) {
    for (var dX = -1; dX <= 1; dX++) {
      for (var dY = -1; dY <= 1; dY++) {
        if (x + dX >= 0 && x + dX < lines.length && y + dY >= 0 && y + dY < lines.elementAt(x + dX).length) {
          if (!isDigitAt(lines.elementAt(x + dX), y + dY) && lines.elementAt(x + dX)[y + dY] != ".") {
            return true;
          }
        }
      }
    }

    return false;
  }

  List<int> getNumbers(List<String> lines) {
    var numbers = <int>[];

    for (var x = 0; x < lines.length; x++) {
      var line = lines.elementAt(x) + ".";
      var number = "";
      var valid = false;

      for (var y = 0; y < line.length; y++) {
        if (isDigitAt(line, y)) {
          number += line[y];
          valid = valid || isValidAt(lines, x, y);
        }

        if (number.isNotEmpty && !isDigitAt(line, y)) {
          if (valid) {
            numbers.add(int.parse(number));
          }
          number = "";
          valid = false;
        }
      }
    }

    return numbers;
  }

  List<String> loadFile() {
    return file.readAsLinesSync();
  }
}

void main() {
  var main = Main();

  print(main.getNumbers(main.loadFile()).reduce((value, element) => value + element));
}
