SUMMARY = "Help browser for the GNOME desktop"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = " \
    file://COPYING;md5=6e1b9cb787e76d7e6946887a65caa754 \
"

inherit gnomebase itstool autotools-brokensep gsettings gettext gtk-doc features_check mime-xdg

# for webkitgtk
REQUIRED_DISTRO_FEATURES = "x11"

SRC_URI[archive.sha256sum] = "456a6415647bceeb0159b90b3553ff328728cf29a608fce08024232504ccb874"

DEPENDS += " \
    libxml2-native \
    glib-2.0-native \
    gtk+3 \
    appstream-glib \
    libxslt \
    sqlite3 \
    webkitgtk \
    yelp-xsl \
"
PACKAGECONFIG ?= ""

# Enable if soup3 is enabled in webkit recipe
PACKAGECONFIG[soup3] = ",--with-webkit2gtk-4-0,"

do_configure:prepend() {
    export ITSTOOL=${STAGING_BINDIR_NATIVE}/itstool
}

FILES:${PN} += " \
    ${datadir}/metainfo \
    ${datadir}/yelp-xsl \
"

RDEPENDS:${PN} += "yelp-xsl"
