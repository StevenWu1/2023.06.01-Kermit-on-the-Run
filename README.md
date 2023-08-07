# 2023.06.01-Kermit-on-the-Run
A classic movie trope is to have a montage of some athlete getting into shape by training. A scene in the Memes movie will have Kermit the Frog training to run a cross country race, while fighting the dastardly suggestions of Evil Kermit. At the end of the scene, we'll see the results of the race, but everyone decides it would be a good idea to make the results realistic, which requires someone to figure out how to score a cross country meet.

Scoring works under the following rules:

1. A team qualifies to place in the meet if they have at least 5 finishers
2. Finishers on incomplete teams are ignored for determining the place of finishers on complete teams
3. A team's score is the sum of their top 5 finisher places
4. A team's 6th and 7th place finisher does not count to the team score, but they work as displacers - anyone who finishes after them will have a worse finishing place than if the 6th and 7th place finishers hadn't run at all
5. Any finisher after 7th place is ignored for determining the place of runners
6. In the even of a tie, the finishing place of the 6th place runners is used. If only one team has a 6th place finisher, then the team with a 6th runner wins the tie. If neither team has a 6th place finisher, then the finishing place of the 5th place runners is used instead to break the tie.

For example, consider the following finishing places:

1st Muppets            10th Sesame Street

2nd Sesame Street      11th Sesame Street

3rd Fraggle Rock       12th Muppets

4th Muppets            13th Sesame Street

5th Muppets            14th Sesame Street

6th Fraggle Rock       15th Sesame Street

7th Fraggle Rock       16th Muppets

8th Sesame Street      17th Sesame Street

9th Sesame Street      18th Muppets

Note that only Muppets and Sesame Street have complete teams. For scoring the meet, only their finishers count. For the purposes of calculating scores, here is how places are actually assigned. Notice that the last two Sesame Street runners do not count for scoring at all as they are after the 7th place finisher.

1st Muppets            7th  Sesame Street

2nd Sesame Street      8th  Sesame Street

--- Fraggle Rock       9th  Muppets

3rd Muppets            10th Sesame Street

4th Muppets            11th Sesame Street

--- Fraggle Rock       ---  Sesame Street

--- Fraggle Rock       12th Muppets

5th Sesame Street      ---  Sesame Street

6th Sesame Street      13th Muppets


The finishing results would be:

1st place - Sesame Street (score of 2 + 5 + 6 + 7 + 8 = 28)

2nd place - Muppets (score of 1 + 3 + 4 + 9 + 12 = 29)

Notice that the team with the lower score wins!

Skeleton Code

##### Input Format
First line will be a single integer n Each of the next n lines will have a team name

##### Constraints
1 <= n <= 1000 There will be at least one fully qualified team

##### Output Format
The finishing order and scores of all fully qualified teams

##### Sample Input 0
18
Muppets
Sesame Street
Fraggle Rock
Muppets
Muppets
Fraggle Rock
Fraggle Rock
Sesame Street
Sesame Street
Sesame Street
Sesame Street
Muppets
Sesame Street
Sesame Street
Sesame Street
Muppets
Sesame Street
Muppets

##### Sample Output 0
Sesame Street: 28
Muppets: 29

##### Sample Input 1
12
Cubs
Sox
Cubs
Sox
Sox
Cubs
Cubs
Sox
Sox
Sox
Cubs
Cubs

##### Sample Output 1
Sox: 28
Cubs: 28
