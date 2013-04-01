# lein-xml

<a href=http://www.smbc-comics.com/?id=2491">A lot</a> of <a
href="https://groups.google.com/group/clojure/browse_thread/thread/1d97dff96dbc5430">people</a>
look at lisp languages and are horrified by the parentheses
everywhere. Golly, there sure are a lot! Wouldn't it be nicer if you
could define your Leiningen project in terms of friendly old XML?

<img src="xml-situps.png">

Well now you can!

## Usage

You'll still need a short bootstrap `project.clj` file to kick things off:

```clj
(defproject _ "whatever" :plugins [[lein-xml "1.0.0"]])
```

Then put your real configuration in `project.xml`:

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project>
  <groupId>org.leiningen</groupId>
  <artifactId>sample</artifactId>
  <version>0.1.0-SNAPSHOT</version>
  <description>Just some kind of sample thing</description>
  <url>https://github.com/technomancy/lein-xml</url>
  <dependencies>
    <dependency>
      <groupId>org.clojure</groupId>
      <artifactId>clojure</artifactId>
      <version>1.5.1</version>
    </dependency>
    <dependency>
      <groupId>slamhound</groupId>
      <artifactId>slamhound</artifactId>
      <version>1.3.3</version>
    </dependency>
  </dependencies>
</project>
```

Not all keys from `project.clj` are supported in `project.xml`.
Patches welcome.

## License

Copyright © 2013 Phil Hagelberg

Distributed under the Eclipse Public License, the same as Clojure.
