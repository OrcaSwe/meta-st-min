SUMMARY = "OpenSTLinux core image."
LICENSE = "Proprietary"

include recipes-st/images/st-image.inc

inherit core-image

IMAGE_LINGUAS = "en-us"

IMAGE_FEATURES += "\
    package-management \
    ssh-server-dropbear \
    "

#
# Display part addons
#
IMAGE_DISPLAY_PART = " \
    libdrm          \
    libdrm-tests    \
"

#
# INSTALL addons
#
CORE_IMAGE_EXTRA_INSTALL += " \
    ${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'systemd-networkd-configuration', '', d)} \
    \
    ${IMAGE_DISPLAY_PART}                       \
    "
