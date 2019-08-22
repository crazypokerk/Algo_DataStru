module.exports = function main(str) {
    var len = str.length;
    var num = String(str).split(",");

    var zero = ["._.", "|.|", "|_|"];

    var one = ["...", "..|", "..|"];

    var two = ["._.", "._|", "|_."];

    var three = ["._.", "._|", "._|"];

    var four = ["...", "|_|", "..|"];

    var five = ["._.", "|_.", "._|"];

    var six = ["._.", "|_.", "|_|"];

    var seven = ["._.", "..|", "..|"];

    var eight = ["._.", "|_|", "|_|"];

    var nine = ["._.", "|_|", "..|"];


    var number = [zero, one, two, three, four, five, six, seven, eight, nine];

    var txt = "";

    for (i = 0; i < 3; i++) {
        for (j = 0; j < len; j++) {
            txt += number[parseInt(num[j])][i];
        }
        txt.trim();
        txt += '\n';
    }
    console.log(txt);
    return txt;

};