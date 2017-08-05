## Android-SharedPreferences-Helper

**Simplifies usage of the default Android SharedPreferences Class.**

Library size = ~15kb only. The developer can do in a few lines of code which otherwise would have required several. Simple to understand as compared to the default class and easy to use.

## Salient Features

Library size: Just **~15 KB**

- One line initialization and setup
- Easily selecting whether to use default preferences or a custom preference file
- Predefined (data type defaults) and customizable (what you may choose) default values for each datatype
- Ability to set different default value for single use with just an additional param
- You can register and unregister `OnSharedPreferenceChangeListener` as you do for default class 

## Installation/Setup

[ ![Download](https://api.bintray.com/packages/viralypatel/maven/Android-SharedPreferences-Helper/images/download.svg) ](https://bintray.com/viralypatel/maven/Android-SharedPreferences-Helper/_latestVersion)

> ##### Gradle Dependency (recommended)

Add the following to your module's `build.gradle`:

    dependencies {
        ...
        ...
        compile(group: 'com.viralypatel.sharedpreferenceshelper', name: 'library', version: '1.1.0', ext: 'aar')
    }


> ##### Maven

    <dependency>
            <groupId>com.viralypatel.sharedpreferenceshelper</groupId>
            <artifactId>library</artifactId>
            <version>1.1.0</version>
            <type>aar</type>
    </dependency>

> ##### Add aar file locally

You can also download the `library-<version>.aar` file from [this page](https://bintray.com/viralypatel/maven/Android-SharedPreferences-Helper/view#files) if you want to add it locally inside the project.

> ##### Use the source code

In case you want to customize it more to your needs:

- Clone this repository to your system
- Import the library module to your project and use

If you are customizing it and feel that the customizations are generic and would add value for other users of this library: **Pull Requests are most welcome! :-)**

## Usage

> **Declaration of `SharedPreferencesHelper` object: (recommended at class level)**

    SharedPreferencesHelper sph; 
    
> **Instantiation of the `SharedPreferencesHelper` object: (recommended in `onCreate()` method)**
 
        // use one of the following ways to instantiate
        sph = new SharedPreferencesHelper(this); //this will use default shared preferences
        sph = new SharedPreferencesHelper(this, "myappprefs"); // this will create a named shared preference file
        sph = new SharedPreferencesHelper(this, "myappprefs", 0); // this will allow you to specify a mode

> **Putting values into shared preferences**

Fairly simple! Unlike the default way (when using the `SharedPreferences` class) you'll **NOT** need to call `.edit()` and `.commit()` ever time.

        sph.putBoolean("boolKey", true);
        sph.putInt("intKey", 123);
        sph.putString("stringKey", "string value");
        sph.putLong("longKey", 456876451);
        sph.putFloat("floatKey", 1.51f);

        // putStringSet is supported only for android versions above HONEYCOMB
        Set name = new HashSet();
        name.add("Viral");
        name.add("Patel");
        sph.putStringSet("name", name);

That's it! Your values are stored in the shared preferences.

> **Getting values from shared preferences**

Again, just one simple method call with the key name.

        sph.getBoolean("boolKey");
        sph.getInt("intKey");
        sph.getString("stringKey");
        sph.getLong("longKey");
        sph.getFloat("floatKey");

        // getStringSet is supported only for android versions above HONEYCOMB
        sph.getStringSet("name");

## Advanced Usage

**What if the value is not set for a given key already?** : It returns the default value.
 Default values are as follows:
 
        private int intDefaultVal = 0;
        private long longDefaultVal = 0;
        private float floatDefaultVal = 0;
        private boolean boolDefaultVal = false;
        private String stringDefaultVal = "";
        private Set<String> stringSetDefaultVal = null;

**What if i want a different value as default for each type?** : Check the next section to see how to change default value.

**What if i want a different default value only for a partylar key?** : Yes, you can achieve that by passing it as an additional parameter in the get method as follows:
 
        sph.getBoolean("boolKey", true);
        sph.getInt("intKey", -1);
        sph.getString("stringKey", "my custom default string");
        sph.getLong("longKey", -222);
        sph.getFloat("floatKey", -13.76f);

        // getStringSet is supported only for android versions above HONEYCOMB
        sph.getStringSet("name", new HashSet<String>());
 
> **Setting default values for each data type when no values are set**

Be careful with this as this will set the default value for the data type.

        sph.setBoolDefaultVal(true);
        sph.setFloatDefaultVal(-3.6f);
        sph.setIntDefaultVal(-3);
        sph.setLongDefaultVal(-999);
        sph.setStringDefaultVal("custom default string");
        sph.setStringSetDefaultVal(new HashSet<String>());

> **Registering an `OnSharedPreferenceChangeListener` for the shared preferences** 

Just like you do it for the normal `SharedPreferences` instance:

        SharedPreferences.OnSharedPreferenceChangeListener listener = new SharedPreferences.OnSharedPreferenceChangeListener() {
            @Override
            public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
                // do what you got to do here
            }
        };
        
        sph.registerListener(listener);

> Unregistering the `OnSharedPreferenceChangeListener` (if registered)

Simply unregister the `listener` you registered above.

        sph.unregisterListener(listener);

## License

> Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with the License. You may obtain a copy of the License at `http://www.apache.org/licenses/LICENSE-2.0`

> Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the specific language governing permissions and limitations under the License.





