#### Flashing
To flash image to  SD card:
``` bash
$ sudo chmod 666 /dev/sdb
$ oe-run-native bmap-tools-native bmaptool copy ./core-image-minimal-beaglebone-yocto.wic /dev/sdb
```
#### Writing recipe
> A recipe describes how to handle a given software component (application, library,...). 
> It is a set of instructions to describe how to retrive, patch, compile, install and generate binary packages, and also the build time dependencies.

In the Lab 2, an entire program is written and compiled using older GCC version, which is below 10. 
So when we use the new one (exp. 12 in my computer), the program will have multiple definition issues, which can be fixed by applying `-fcommon` flag to the GCC.
```bash
...

EXTRA_CFLAGS = "-fcommon"
EXTRA_OEMAKE = "CC='${CC}' CFLAGS='${EXTRA_CFLAGS}'"

...
```
#### Variables
- Variable *names* are in upper-case
- Variable *values* are strings.
- Variable defined in **Configuration Files** have a **global** scope.
- Variables defined in **Recipes** have a **local** scope.
```bash
+= append (with space)
=+ prepend (with space)

.= append (without space)
=. prepend (without space)
```
- The `?=` operator assigns a value only if the variables has not been assigned when the statement is parsed.
```bash
COLOUR ?= "unknown"
COLOUR = "blue"
```
Result: COLOUR = "blue"
```bash
COLOUR ?= "unknown"
```
Result: COLOUR = "unknown"
- The `??=` operator assigns a value only if the variables has not been assigned when the statement is parsed, not even using a `?=` operator.

> To avoid the problem, avoid using `+=, =+, .=, =.` in `$BUILDDIR/conf/local.conf`. Always use overrides

- The `append` override adds **at the end** of the variables (without space).
- The `prepend` override adds **at the start** of the variables (without space).
- The `remove` override removes all occurrences of  a value within a variable.
#### Layers
> Layers allow to isolate and organize the metadata. Or we can say that: A layer is a collection of recipes.

Create a layer command:
```bash
bitbake-layers create-layer -p <PRIORITY> <layer>`
```

#### BSP layers
>BSP layers are a subset of the layers. Or we can say that:  a BSP is, in itself, a special type of layer. 
>They hold metadata with the purpose of supporting a specific class of hardware devices.

They usually provide:
- Hardware configuration files (*machines*).
- Custom kernel and bootloader recipes and configurations.
- Modules and drives to enable specific hardware features (e.g. multimedia accelerators).
- Pre-built user binaries and firmware.

#### Custom image
A build is mainly defined by two files: the machine configuration and the image recipe.
The image recipe is the top level file for the generated rootfs and the packages it includes.

#### The Yocto Project SDK
An SDK (Software Development Kit) is a set of tools allowing the development of applications for a given target (operating system, platform, environment,... )

It generally provides a set of tools including:
- Compilers and cross-compilers
- Linkers
- Library headers
- Debuggers
- Custom utilities

Two different SDKs can be generated:
- A generic SDK, including:
	- A toolchain.
	- Common tools.
	- A collection of basic libraries.
	```bash
	bitbake meta-toolchain
	```
- An -image-based SDK, including:
	- The generic SDK.
	- The sysroot matching the target root filesystem.
	```bash
	bitbake -c populate_sdk <image_name>
	```
Both SDKs are distributed as bash scripts.
These scripts self extract themselves to install the toolchains and the files they provide.

#### Devtool
> *Devtool* is a set of utilities to ease the inegration and the development of OpenEmbedded recipes.

It can be used to:
- Generate a recipe for a given upstream application.
- Modify an existing recipe and its associated sources.
- Upgrade an existing recipe to use a newer upstream application.

There are three ways of creating a new *devtool* project:
- To create a new recipe:
```bash
devtool add <recipe> <fetchuri>
```
where *recipe* is the recipe's name.
*fetchuri* can be a local path or remote *uri*
- To modify the source for an existing recipe:
```bash
devtool modify <recipe>
```
- To upgrade a given recipe:
```bash
devtool upgrade -V <version> <recipe>
```




