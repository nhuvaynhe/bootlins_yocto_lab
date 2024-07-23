# FIXME: the LIC_FILES_CHKSUM values have been updated by 'devtool upgrade'.
# The following is the difference between the old and the new license text.
# Please update the LICENSE value if needed, and summarize the changes in
# the commit message via 'License-Update:' tag.
# (example: 'License-Update: copyright years updated.')
#
# The changes:
#
# --- COPYING
# +++ COPYING
# @@ -1,7 +1,7 @@
#                      GNU GENERAL PUBLIC LICENSE
#                         Version 3, 29 June 2007
#  
# - Copyright (C) 2007 Free Software Foundation, Inc. <http://fsf.org/>
# + Copyright (C) 2007 Free Software Foundation, Inc. <https://fsf.org/>
#   Everyone is permitted to copy and distribute verbatim copies
#   of this license document, but changing it is not allowed.
#  
# @@ -645,7 +645,7 @@
#      GNU General Public License for more details.
#  
#      You should have received a copy of the GNU General Public License
# -    along with this program.  If not, see <http://www.gnu.org/licenses/>.
# +    along with this program.  If not, see <https://www.gnu.org/licenses/>.
#  
#  Also add information on how to contact you by electronic and paper mail.
#  
# @@ -664,11 +664,11 @@
#    You should also get your employer (if you work as a programmer) or school,
#  if any, to sign a "copyright disclaimer" for the program, if necessary.
#  For more information on this, and how to apply and follow the GNU GPL, see
# -<http://www.gnu.org/licenses/>.
# +<https://www.gnu.org/licenses/>.
#  
#    The GNU General Public License does not permit incorporating your program
#  into proprietary programs.  If your program is a subroutine library, you
#  may consider it more useful to permit linking proprietary applications with
#  the library.  If this is what you want to do, use the GNU Lesser General
#  Public License instead of this License.  But first, please read
# -<http://www.gnu.org/philosophy/why-not-lgpl.html>.
# +<https://www.gnu.org/licenses/why-not-lgpl.html>.
# 
#

# Recipe created by recipetool
# This is the basis of a recipe and may need further editing in order to be fully functional.
# (Feel free to remove these comments when editing.)

# WARNING: the following LICENSE and LIC_FILES_CHKSUM values are best guesses - it is
# your responsibility to verify that the values are complete and correct.
LICENSE = "GPL-3.0-or-later"
LIC_FILES_CHKSUM = "file://COPYING;md5=1ebbd3e34237af26da5dc08a4e440464"

SRC_URI = "${GNU_MIRROR}/hello/hello-${PV}.tar.gz \
           file://0001-Change-msg.patch \
           "
SRC_URI[sha1sum] = "f7bebf6f9c62a2295e889f66e05ce9bfaed9ace3"
SRC_URI[sha256sum] = "8d99142afd92576f30b0cd7cb42a8dc6809998bc5d607d88761f512e26c7db20"
SRC_URI[sha384sum] = "3ba72897cfb76d572423afca9f689e1503c4656bb04a670d3b9a950e88df71551b46917bbe71fc3271970157eeb02bcb"
SRC_URI[sha512sum] = "e301d785135c52575a8b4c35994c0316f8d366451f604eb5e74c1f907077502aebd5a1a32cd1e26cd7ca32c22f4de5623a335f8ae7e735ac977420df664f01de"

# NOTE: if this software is not capable of being built in a separate build directory
# from the source, you should replace autotools with autotools-brokensep in the
# inherit line
inherit gettext autotools-brokensep
