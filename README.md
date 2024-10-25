# Angry Birds Clone - Static GUI Implementation
## CSE201 Advanced Programming Project

### Github Link : https://github.com/mrayhankhan/AngryBirds_LibGDX

### Team Members
- M Rayhankhan 2022269 	
- Raunak Kumar Giri 2023427

### Project Overview
A Java-based clone of Angry Birds using the LibGDX framework. This submission implements the static GUI components of the game including all screens, menus, and visual elements without the actual gameplay mechanics.

This project was generated with [gdx-liftoff](https://github.com/libgdx/gdx-liftoff) and uses a template including simple application launchers and an `ApplicationAdapter` extension.

### Prerequisites
- Java Development Kit (JDK) 17 or higher
- Gradle 7.0 or higher
- LibGDX 1.12.0
- Any IDE that supports Java and Gradle (IntelliJ IDEA recommended)

### Project Structure

#### Platforms
- `core`: Main module with the application logic shared by all platforms.
- `lwjgl3`: Primary desktop platform using LWJGL3 (called 'desktop' in older docs).

[Previous sections remain the same until Project Structure]

### Project Structure

#### Platforms
- `core`: Main module with the application logic shared by all platforms.
- `lwjgl3`: Primary desktop platform using LWJGL3 (called 'desktop' in older docs).

#### Source Code Structure
```
core/src/main/java/com/angrybirds/
├── Assets.java              # Asset management class
├── Bird.java               # Base bird functionality
├── Blackbird.java          # Explosive bird type
├── Block.java              # Block functionality
├── Bluebird.java          # Blue bird type
├── Decoypig.java          # Decoy pig enemy
├── Eagle.java             # Eagle bird type
├── gamescreen.java        # Main game screen
├── Gamescreenang.java     # Game screen variation
├── gameScreenlevel.java   # Level screen implementation
├── Helmetpig.java         # Helmet-wearing pig enemy
├── Iceblock.java          # Ice block type
├── Kingpig.java           # King pig enemy
├── levelclass.java        # Level management
├── Losescreen.java        # Game over screen
├── Mustachepig.java       # Mustache pig enemy
├── Orangebird.java        # Orange bird type
├── Pig.java               # Basic pig functionality
├── Pigengineer.java       # Engineer pig enemy
├── Steelblock.java        # Steel block type
├── Whitebird.java         # White bird type
├── WinningScreen.java     # Victory screen
├── Woodenblock.java       # Wooden block type
└── Yellowbird.java        # Yellow bird type

build.gradle               # Gradle build configuration
```

### Class Descriptions

#### Game Management
- `Assets.java`: Handles loading and managing all game assets including textures, sounds, and music
- `levelclass.java`: Manages level creation, loading, and progression

#### Birds
- `Bird.java`: Contains basic bird functionality and properties
- `Blackbird.java`: Implementation of the black explosive bird
- `Bluebird.java`: Implementation of the blue splitting bird
- `Eagle.java`: Implementation of the eagle bird
- `Orangebird.java`: Implementation of the orange bird
- `Whitebird.java`: Implementation of the white egg-dropping bird
- `Yellowbird.java`: Implementation of the yellow speeding bird

#### Pigs
- `Pig.java`: Contains basic pig functionality and properties
- `Decoypig.java`: Implementation of decoy pig
- `Helmetpig.java`: Implementation of armored pig with helmet
- `Kingpig.java`: Implementation of the king pig
- `Mustachepig.java`: Implementation of mustached pig
- `Pigengineer.java`: Implementation of engineer pig

#### Blocks
- `Block.java`: Contains basic block functionality and properties
- `Iceblock.java`: Implementation of destructible ice blocks
- `Steelblock.java`: Implementation of durable steel blocks
- `Woodenblock.java`: Implementation of wooden blocks

#### Screens
- `gamescreen.java`: Base game screen implementation
- `Gamescreenang.java`: Alternative game screen implementation
- `gameScreenlevel.java`: Level-specific game screen
- `Losescreen.java`: Screen shown when player loses
- `WinningScreen.java`: Screen shown when player wins

[Rest of the README remains the same]

### Gradle Tasks and Usage
This project uses [Gradle](https://gradle.org/) to manage dependencies. The Gradle wrapper is included, so you can run Gradle tasks using `gradlew.bat` or `./gradlew` commands.

#### Key Gradle Tasks
- `lwjgl3:run`: Starts the application
- `lwjgl3:jar`: Builds application's runnable jar (found at `lwjgl3/build/libs`)
- `build`: Builds sources and archives of every project
- `clean`: Removes `build` folders containing compiled classes and built archives
- `test`: Runs unit tests

#### IDE-Specific Tasks
- `eclipse`: Generates Eclipse project data
- `cleanEclipse`: Removes Eclipse project data
- `idea`: Generates IntelliJ project data
- `cleanIdea`: Removes IntelliJ project data

#### Useful Gradle Flags
- `--continue`: Errors won't stop tasks from running
- `--daemon`: Uses Gradle daemon to run tasks
- `--offline`: Uses cached dependency archives
- `--refresh-dependencies`: Forces validation of all dependencies (useful for snapshot versions)

**Note**: Most tasks can be run with `name:` prefix (e.g., `core:clean` only cleans the `core` project)

### Project Setup
1. Clone the repository:
```bash
git clone https://github.com/yourusername/angry-birds-clone.git
cd angry-birds-clone
```

2. Import the project:
- For IntelliJ IDEA:
  - Go to File → Open
  - Navigate to the project directory
  - Select build.gradle
  - Choose "Open as Project"

3. Build the project:
```bash
./gradlew build
```

4. Run the desktop version:
```bash
./gradlew lwjgl3:run
```

### Implemented Features (Static)

#### Screens
1. **Main Menu**
   - Play Game button
   - Level Select button
   - Settings button
   - Exit button
   - Background animation

2. **Level Select**
   - 3 level buttons with preview images
   - Return to main menu button
   - Level unlock status indicators

3. **Game Screen**
   - Slingshot placement
   - Bird queue display
   - Score display
   - Pause button
   - Level progress indicator
   - Static placement for:
     - Birds (3 types)
     - Pigs (3 types)
     - Blocks (3 materials: wood, glass, steel)

4. **Pause Screen**
   - Resume button
   - Restart level button
   - Return to menu button
   - Settings options

5. **Level Complete Screen**
   - Star rating display
   - Score display
   - Next level button
   - Retry level button
   - Return to menu button

### Controls (Static Implementation)
- Click and drag functionality for birds (visual only)
- Click interactions for all buttons
- Menu navigation
- Screen transitions

### Asset Credits
All assets used in this project are either:
1. Created by the team
2. Used under appropriate licenses from:
   - [List external asset sources here]

### Known Issues
1. Some button hover effects may not display correctly on Linux systems
2. Screen transition animations occasionally stutter on lower-end systems

### Development Notes
- The project uses Scene2D.ui for all UI elements
- Texture atlases are used for efficient rendering
- Screen transitions use the LibGDX Screen interface
- All fonts are loaded using FreeTypeFontGenerator
- Viewport is configured for multiple screen resolutions

### Testing
To run the basic UI tests:
```bash
./gradlew test
```

### Building for Distribution
To create a distributable JAR:
```bash
./gradlew lwjgl3:jar
```
The JAR will be located in `lwjgl3/build/libs/`.


### References
1. LibGDX Documentation: https://libgdx.com/wiki/
2. Scene2D.ui Tutorial: https://github.com/libgdx/libgdx/wiki/Scene2d.ui

### Version
- Static GUI Implementation (Deadline 2)
