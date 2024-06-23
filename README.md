# Game of life | Jogo da Vida
## Origin
Conceived by mathematician John Horton Conway in 1970, the Game of Life is a cellular automaton that simulates the evolution of life in a discrete environment. 
The game is based on simple rules that determine the birth, death, and survival of cells in a two-dimensional grid.

## Implementation
This project presents an implementation of the Game of Life in java programming language. The code simulates the evolution of the game over multiple generations, 
following the rules defined by Conway:

1. Birth: A dead cell with exactly three living cells in its neighborhood becomes alive in the next generation.
2. Survival: A living cell with two living neighbors in the next generation remains alive.
3. Isolation: A living cell with fewer than two living neighbors in the next generation dies of loneliness.
4. Overcrowding: A living cell with more than three living neighbors in the next generation dies due to overcrowding.

## Why did you decide to do this?
As it was one of the questions in the first level of the OBI in 2024 and the only one that I couldn't finish in less time than the test, 
I felt challenged to finalize my algorithm and look for efficient ways to solve it.

## How to use
1. Download the [JAR file](https://github.com/AndreKaled/JogoDaVida/releases/download/v1.o/JogoDaVida.jar)
2. Navigate to the location of the downloaded Jar file
3. Execute the file with the command
   ```cmd
   java -jar JogoDaVida.jar
   ```
5. Be happy :)
