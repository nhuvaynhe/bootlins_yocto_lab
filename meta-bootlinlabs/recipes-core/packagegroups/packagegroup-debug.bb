SUMMARY = "Package for debug"

inherit packagegroup

RDEPENDS:${PN} = "\
    gdb \
    gdbserver"

