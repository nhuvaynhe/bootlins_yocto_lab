SUMMARY = "ninvader game"
DESCRIPTION = "A terminal based game"
HOMEPAGE = "https://ninvaders.sourceforge.net"
SECTION = "game"

LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://gpl.txt;md5=393a5ca445f6965873eca0259a17f833"

DEPENDS = "ncurses (>= 5.2)"

SRC_URI = "${SOURCEFORGE_MIRROR}/${BPN}/${BPN}-${PV}.tar.gz"
SRC_URI[md5sum] = "97b2c3fb082241ab5c56ab728522622b"

EXTRA_CFLAGS = "-fcommon"

EXTRA_OEMAKE = "CC='${CC}' CFLAGS='${EXTRA_CFLAGS}'"

do_compile() {
    oe_runmake
}

do_install() {
    install -d ${D}${bindir}
    install -m 0755 nInvaders ${D}${bindir}
}
