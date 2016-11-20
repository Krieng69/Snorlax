# Snorlax [![Build Status](https://travis-ci.org/alucas/Snorlax.svg?branch=master)](https://travis-ci.org/alucas/Snorlax) [![License](https://img.shields.io/badge/license-apache%202.0-blue.svg)](http://www.apache.org/licenses/LICENSE-2.0.html) [![Donate](https://img.shields.io/badge/Donate-PayPal-green.svg)](https://github.com/alucas/Snorlax#donation)
Check pokemons stats. [Available through Xposed repository](http://repo.xposed.info/module/com.icecream.snorlax)
  
This module acts as a [man in the middle](https://en.wikipedia.org/wiki/Man-in-the-middle_attack) on Pokémon Go's communications with the server, and allows us to add extra features to the game.

### Features:
- Prevent PokemonGo from detecting GPS is being spoofed (similar to Mock Mock Locations)
- Replace pokemons name with custom formats ([details](https://github.com/igoticecream/Snorlax/wiki/Custom-formats)) :
  - Nickname
  - Level
  - Type
  - Moves (name, type, power)
  - IV (%, attack, defence, stamina)
  - HP (current, max)
  - CP (current, evolution)
  - <img src="https://cloud.githubusercontent.com/assets/498613/20310033/ad7431c4-ab4a-11e6-9ad2-e0c84b9f9b5a.png" width="300px">
- Show pokemon stats as a system notification when you encounter them :
  - <img src="https://cloud.githubusercontent.com/assets/498613/20327949/bf40e2c2-ab8f-11e6-81c9-4a250243d647.png" width="300px">
  - <img src="https://cloud.githubusercontent.com/assets/498613/20327954/c40ca502-ab8f-11e6-9d92-1e0d40027221.png" width="300px">
- Show catch results (Success, Missed, Flee) as soon as you throw your pokeball
- Show lure's remaining time
  - <img src="https://cloud.githubusercontent.com/assets/498613/20309733/6732152e-ab49-11e6-9f8c-a7276da34080.png" width="300px">

### Dev features:
- Broadcast [Intent](https://developer.android.com/reference/android/content/Intent.html) with nearby pokemon informations
- Log network traffic (use Protobuf's ```protoc``` to decode it)



## Libraries and tools
- Android's support libraries
- Reactive extensions: [RxJava](https://github.com/ReactiveX/RxJava), [RxAndroid](https://github.com/ReactiveX/RxAndroid), [RxBinding](https://github.com/JakeWharton/RxBinding) and [RxRelay](https://github.com/JakeWharton/RxRelay)
- Dependency injector: [Dagger 2](http://google.github.io/dagger/)
- Android's views binding: [Butterknife](https://github.com/JakeWharton/butterknife)
- Logging utility: [Timber](https://github.com/JakeWharton/timber)
- Generated immutable value classes: [AutoValue](https://github.com/google/auto/tree/master/value)
- [Xposed framework](https://github.com/rovo89/XposedBridge)
- [Protobuf](https://github.com/google/protobuf-gradle-plugin)

## Build requirements
- JDK 1.8
- [Android SDK](http://developer.android.com/sdk/index.html)
- Android N [(API 24) ](http://developer.android.com/tools/revisions/platforms.html)
- Latest Android SDK Tools and build tools
- Lombok plugin for Android Studio / IntelliJ IDEA
- Your device must be rooted and the xposed framekwork must be installed. You can download the xposed framework [here](http://repo.xposed.info/module/de.robv.android.xposed.installer).

## Build source
Clone the repository (you must have Git installed)
```
git clone https://github.com/alucas/Snorlax.git
cd .\Snorlax\
git submodule update --init
```

Build
```
.\gradlew build
```

To build a release APK
```
.\gradlew assembleRelease
```

To install directly to the phone connected via ADB
```
.\gradlew installRelease
```

## Contributing
  - Fork it!
  - Create your feature branch: `git checkout -b my-new-feature`
  - Commit your changes: `git commit -am 'Useful information about your new features'`
  - Push to the branch: `git push origin my-new-feature`
  - Submit a pull request on the `dev` (all pull request on master branch will be rejected)

## Special thanks
Snorlax would not have been possible without:
- [chuparCh0pper](https://github.com/chuparCh0pper/PoGoIV_xposed) for his awesome [module](https://github.com/chuparCh0pper/PoGoIV_xposed) which Snorlax is inspired on
- [ELynx](https://github.com/ELynx) for the method to MITM PokemonGo communications, check his [repo](https://github.com/ELynx/pokemon-go-xposed-mitm) too
- And last but not least, [AeonLucid](https://github.com/AeonLucid) for the [PokemonGo's protos](https://github.com/AeonLucid/POGOProtos)

## Donation
I hope you are liking Snorlax!

If you do, you can support this project to keep coming with new features by buying me a cup of coffee (so i can code by night) or a BigMac at McDonalds. Click the link below and thanks you!

[Donate (igoticecream)](https://www.paypal.com/cgi-bin/webscr?cmd=_s-xclick&hosted_button_id=A9PPGNDJEC33E)

[Donate (alucas)](https://www.paypal.me/antoinelucas)

## License
    Copyright (c) 2016. Pedro Diaz <igoticecream@gmail.com>

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

        http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
