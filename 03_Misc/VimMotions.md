d = delete <br>
dd = delete whole line<br>
$ = end of line<br>
^ = start of line excluding white space<br>
w = word/start of next word<br>
e = end of word<br>
p = put previously deleted text after cursor (paste)<br>
r = replace<br>
c = change (delete and go in insert mode)<br>
cc = change whole line<br>
b = back to start of word<br>
gg = go to first line<br>
G = last line<br>
\[number] G = go to \[number] line<br>
\/  \<text> \<Enter> = search \<text> ahead of current position<br>
? \<text> \<Enter> =  search before current position <br>
n = next match of search <br>
N = previous match of search <br>
% = find matching parentheses
:s/\<replaced text>/\<new text> = change the first occurrence of \<replaced text> with \<new text> <br>
:s/\<replaced text>/\<new text>/g = change for all found matches on the current line <br>
:\<line number>,\<line number>s/replaced/new/g = change matches on specified lines<br>
:%s/replaced/new/g = replace in the whole file <br>
:%s/replaced/new/gc = replace in the whole file with prompt <br>
o = create a new line below and insert (open)<br>
O = create a new line above and insert <br>
a = insert after the cursor (append)<br>
A = append line <br>
i = insert in front of the cursor <br>
R = continuous replacement <br>
y = copy (yank) <br>
yy = copy line <br>
:set ic = ignore case search<br>
:set noic = case sensitive search

v = highligting (visual) mode <br>
V = line visual mode <br>
gcap = highligh whole paragraph <br>