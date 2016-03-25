/** @file eucalyptus-opts.h
 *  @brief The header file for the command line option parser
 *  generated by GNU Gengetopt version 2.22.5
 *  http://www.gnu.org/software/gengetopt.
 *  DO NOT modify this file, since it can be overwritten
 *  @author GNU Gengetopt by Lorenzo Bettini */

#ifndef EUCALYPTUS_OPTS_H
#define EUCALYPTUS_OPTS_H

/* If we use autoconf.  */
#ifdef HAVE_CONFIG_H
#include "config.h"
#endif

#include <stdio.h> /* for FILE */

#ifdef __cplusplus
extern "C" {
#endif /* __cplusplus */

#ifndef ARGUMENTS_PACKAGE
/** @brief the program name (used for printing errors) */
#define ARGUMENTS_PACKAGE "Eucalyptus"
#endif

#ifndef ARGUMENTS_PACKAGE_NAME
/** @brief the complete program name (used for help and version) */
#define ARGUMENTS_PACKAGE_NAME "Eucalyptus"
#endif

#ifndef ARGUMENTS_VERSION
/** @brief the program version */
#define ARGUMENTS_VERSION "4.3.0"
#endif

#ifndef EUCALYPTUS_ENV_VAR_NAME
//! environment variable for eucalyptus root path set at startup
#define EUCALYPTUS_ENV_VAR_NAME                  "EUCALYPTUS"   //!< Eucalyptus environment variable name
#endif

#ifndef EUCALYPTUS_USER_ENV_VAR_NAME
//! environment variable for eucalyptus user set at startup
#define EUCALYPTUS_USER_ENV_VAR_NAME             "EUCA_USER"    //!< Eucalyptus unix user environment variable name
#endif

/** @brief Where the command line options are stored */
struct eucalyptus_opts
{
  const char *help_help; /**< @brief Print help and exit help description.  */
  const char *full_help_help; /**< @brief Print help, including hidden options, and exit help description.  */
  const char *version_help; /**< @brief Print version and exit help description.  */
  char * user_arg;	/**< @brief User to drop privs to after starting. (default='eucalyptus').  */
  char * user_orig;	/**< @brief User to drop privs to after starting. original value given at command line.  */
  const char *user_help; /**< @brief User to drop privs to after starting. help description.  */
  char * home_arg;	/**< @brief Eucalyptus home directory. (default='/').  */
  char * home_orig;	/**< @brief Eucalyptus home directory. original value given at command line.  */
  const char *home_help; /**< @brief Eucalyptus home directory. help description.  */
  char * extra_version_arg;	/**< @brief Extra version string. (default='').  */
  char * extra_version_orig;	/**< @brief Extra version string. original value given at command line.  */
  const char *extra_version_help; /**< @brief Extra version string. help description.  */
  int initialize_flag;	/**< @brief Perform first-time setup.  This is run one time (only!) on the first cloud controller before the first time it is run. (default=off).  */
  const char *initialize_help; /**< @brief Perform first-time setup.  This is run one time (only!) on the first cloud controller before the first time it is run. help description.  */
  int upgrade_flag;	/**< @brief Perform database upgrade procedure and exit immediately after completion.  Normally, upgrade is performed in-line with regular execution.  This flag causes upgrade to be run and then for the process to terminate.  Useful for debugging upgrade failures. (default=off).  */
  const char *upgrade_help; /**< @brief Perform database upgrade procedure and exit immediately after completion.  Normally, upgrade is performed in-line with regular execution.  This flag causes upgrade to be run and then for the process to terminate.  Useful for debugging upgrade failures. help description.  */
  char * upgrade_old_version_arg;	/**< @brief Upgrade from specified version..  */
  char * upgrade_old_version_orig;	/**< @brief Upgrade from specified version. original value given at command line.  */
  const char *upgrade_old_version_help; /**< @brief Upgrade from specified version. help description.  */
  char * upgrade_old_dir_arg;	/**< @brief Upgrade from specified directory..  */
  char * upgrade_old_dir_orig;	/**< @brief Upgrade from specified directory. original value given at command line.  */
  const char *upgrade_old_dir_help; /**< @brief Upgrade from specified directory. help description.  */
  int upgrade_force_flag;	/**< @brief Skip version check to force upgrade to run again. (default=off).  */
  const char *upgrade_force_help; /**< @brief Skip version check to force upgrade to run again. help description.  */
  char ** bind_addr_arg;	/**< @brief Specifying this option causes eucalyptus-cloud to only bind the specified local addresses.  The default behaviour is to listen on the any address while determining the user facing local address based on default route and netmask size..  */
  char ** bind_addr_orig;	/**< @brief Specifying this option causes eucalyptus-cloud to only bind the specified local addresses.  The default behaviour is to listen on the any address while determining the user facing local address based on default route and netmask size. original value given at command line.  */
  unsigned int bind_addr_min; /**< @brief Specifying this option causes eucalyptus-cloud to only bind the specified local addresses.  The default behaviour is to listen on the any address while determining the user facing local address based on default route and netmask size.'s minimum occurreces */
  unsigned int bind_addr_max; /**< @brief Specifying this option causes eucalyptus-cloud to only bind the specified local addresses.  The default behaviour is to listen on the any address while determining the user facing local address based on default route and netmask size.'s maximum occurreces */
  const char *bind_addr_help; /**< @brief Specifying this option causes eucalyptus-cloud to only bind the specified local addresses.  The default behaviour is to listen on the any address while determining the user facing local address based on default route and netmask size. help description.  */
  char * mcast_addr_arg;	/**< @brief Multicast address to use for group membership.  */
  char * mcast_addr_orig;	/**< @brief Multicast address to use for group membership original value given at command line.  */
  const char *mcast_addr_help; /**< @brief Multicast address to use for group membership help description.  */
  char ** bootstrap_host_arg;	/**< @brief Host to be used for bootstrapping group membership.  Many can be provided.  Note this should only be necessary when UDP multicast is not available..  */
  char ** bootstrap_host_orig;	/**< @brief Host to be used for bootstrapping group membership.  Many can be provided.  Note this should only be necessary when UDP multicast is not available. original value given at command line.  */
  unsigned int bootstrap_host_min; /**< @brief Host to be used for bootstrapping group membership.  Many can be provided.  Note this should only be necessary when UDP multicast is not available.'s minimum occurreces */
  unsigned int bootstrap_host_max; /**< @brief Host to be used for bootstrapping group membership.  Many can be provided.  Note this should only be necessary when UDP multicast is not available.'s maximum occurreces */
  const char *bootstrap_host_help; /**< @brief Host to be used for bootstrapping group membership.  Many can be provided.  Note this should only be necessary when UDP multicast is not available. help description.  */
  int force_remote_bootstrap_flag;	/**< @brief Force the system to boot as a remote component. (default=off).  */
  const char *force_remote_bootstrap_help; /**< @brief Force the system to boot as a remote component. help description.  */
  char ** define_arg;	/**< @brief Set system properties..  */
  char ** define_orig;	/**< @brief Set system properties. original value given at command line.  */
  unsigned int define_min; /**< @brief Set system properties.'s minimum occurreces */
  unsigned int define_max; /**< @brief Set system properties.'s maximum occurreces */
  const char *define_help; /**< @brief Set system properties. help description.  */
  int fork_flag;	/**< @brief Fork and daemonize Eucalyptus. (default=off).  */
  const char *fork_help; /**< @brief Fork and daemonize Eucalyptus. help description.  */
  int kill_flag;	/**< @brief Kill a daemonized Eucalyptus. (default=off).  */
  const char *kill_help; /**< @brief Kill a daemonized Eucalyptus. help description.  */
  char * pidfile_arg;	/**< @brief Location for the pidfile. (default='/var/run/eucalyptus/eucalyptus-cloud.pid').  */
  char * pidfile_orig;	/**< @brief Location for the pidfile. original value given at command line.  */
  const char *pidfile_help; /**< @brief Location for the pidfile. help description.  */
  char * db_home_arg;	/**< @brief Set path to database home directory (default='').  */
  char * db_home_orig;	/**< @brief Set path to database home directory original value given at command line.  */
  const char *db_home_help; /**< @brief Set path to database home directory help description.  */
  int fdlimit_arg;	/**< @brief File descriptor limit effective on jvm (default='65535').  */
  char * fdlimit_orig;	/**< @brief File descriptor limit effective on jvm original value given at command line.  */
  const char *fdlimit_help; /**< @brief File descriptor limit effective on jvm help description.  */
  char * log_level_arg;	/**< @brief Control the log level for console output. (default='INFO').  */
  char * log_level_orig;	/**< @brief Control the log level for console output. original value given at command line.  */
  const char *log_level_help; /**< @brief Control the log level for console output. help description.  */
  char * log_appender_arg;	/**< @brief Control the destination for console output. (default='console-log').  */
  char * log_appender_orig;	/**< @brief Control the destination for console output. original value given at command line.  */
  const char *log_appender_help; /**< @brief Control the destination for console output. help description.  */
  int exhaustive_flag;	/**< @brief Exhaustive logging of all connections. (default=off).  */
  const char *exhaustive_help; /**< @brief Exhaustive logging of all connections. help description.  */
  int exhaustive_db_flag;	/**< @brief Exhaustive logging for database connections. (default=off).  */
  const char *exhaustive_db_help; /**< @brief Exhaustive logging for database connections. help description.  */
  int exhaustive_user_flag;	/**< @brief Exhaustive logging for client connections. (default=off).  */
  const char *exhaustive_user_help; /**< @brief Exhaustive logging for client connections. help description.  */
  int exhaustive_cc_flag;	/**< @brief Exhaustive logging for cluster connections. (default=off).  */
  const char *exhaustive_cc_help; /**< @brief Exhaustive logging for cluster connections. help description.  */
  int exhaustive_external_flag;	/**< @brief Exhaustive logging for external libraries. (default=off).  */
  const char *exhaustive_external_help; /**< @brief Exhaustive logging for external libraries. help description.  */
  char * out_arg;	/**< @brief Redirect standard out to file. (default='&1').  */
  char * out_orig;	/**< @brief Redirect standard out to file. original value given at command line.  */
  const char *out_help; /**< @brief Redirect standard out to file. help description.  */
  char * err_arg;	/**< @brief Redirect standard error to file. (default='&2').  */
  char * err_orig;	/**< @brief Redirect standard error to file. original value given at command line.  */
  const char *err_help; /**< @brief Redirect standard error to file. help description.  */
  int remote_dns_flag;	/**< @brief eucalyptus-cloud will not try to bind port 53. (default=off).  */
  const char *remote_dns_help; /**< @brief eucalyptus-cloud will not try to bind port 53. help description.  */
  int remote_cloud_flag;	/**< @brief DEPRECATED DO NOT USE. IT DOES NOTHING. (default=off).  */
  const char *remote_cloud_help; /**< @brief DEPRECATED DO NOT USE. IT DOES NOTHING. help description.  */
  int remote_walrus_flag;	/**< @brief DEPRECATED DO NOT USE. IT DOES NOTHING. (default=off).  */
  const char *remote_walrus_help; /**< @brief DEPRECATED DO NOT USE. IT DOES NOTHING. help description.  */
  int remote_storage_flag;	/**< @brief DEPRECATED DO NOT USE. IT DOES NOTHING. (default=off).  */
  const char *remote_storage_help; /**< @brief DEPRECATED DO NOT USE. IT DOES NOTHING. help description.  */
  int disable_iscsi_flag;	/**< @brief Disable ISCSI support for dynamic block storage. (default=off).  */
  const char *disable_iscsi_help; /**< @brief Disable ISCSI support for dynamic block storage. help description.  */
  int disable_cloud_flag;	/**< @brief DEPRECATED DO NOT USE. IT DOES NOTHING. (default=off).  */
  const char *disable_cloud_help; /**< @brief DEPRECATED DO NOT USE. IT DOES NOTHING. help description.  */
  int disable_walrus_flag;	/**< @brief DEPRECATED DO NOT USE. IT DOES NOTHING. (default=off).  */
  const char *disable_walrus_help; /**< @brief DEPRECATED DO NOT USE. IT DOES NOTHING. help description.  */
  int disable_dns_flag;	/**< @brief DEPRECATED DO NOT USE. IT DOES NOTHING. (default=off).  */
  const char *disable_dns_help; /**< @brief DEPRECATED DO NOT USE. IT DOES NOTHING. help description.  */
  int disable_storage_flag;	/**< @brief DEPRECATED DO NOT USE. IT DOES NOTHING. (default=off).  */
  const char *disable_storage_help; /**< @brief DEPRECATED DO NOT USE. IT DOES NOTHING. help description.  */
  char ** java_home_arg;	/**< @brief Alternative way to specify JAVA_HOME. (default='/usr/lib/jvm/java-1.7.0').  */
  char ** java_home_orig;	/**< @brief Alternative way to specify JAVA_HOME. original value given at command line.  */
  unsigned int java_home_min; /**< @brief Alternative way to specify JAVA_HOME.'s minimum occurreces */
  unsigned int java_home_max; /**< @brief Alternative way to specify JAVA_HOME.'s maximum occurreces */
  const char *java_home_help; /**< @brief Alternative way to specify JAVA_HOME. help description.  */
  char * jvm_name_arg;	/**< @brief Which JVM type to run (see jvm.cfg). (default='-server').  */
  char * jvm_name_orig;	/**< @brief Which JVM type to run (see jvm.cfg). original value given at command line.  */
  const char *jvm_name_help; /**< @brief Which JVM type to run (see jvm.cfg). help description.  */
  char ** jvm_args_arg;	/**< @brief Arguments to pass to the JVM..  */
  char ** jvm_args_orig;	/**< @brief Arguments to pass to the JVM. original value given at command line.  */
  unsigned int jvm_args_min; /**< @brief Arguments to pass to the JVM.'s minimum occurreces */
  unsigned int jvm_args_max; /**< @brief Arguments to pass to the JVM.'s maximum occurreces */
  const char *jvm_args_help; /**< @brief Arguments to pass to the JVM. help description.  */
  int jmx_flag;	/**< @brief Launch with JMX enabled. (default=off).  */
  const char *jmx_help; /**< @brief Launch with JMX enabled. help description.  */
  int debug_flag;	/**< @brief Launch with debugger enabled. (default=off).  */
  const char *debug_help; /**< @brief Launch with debugger enabled. help description.  */
  int verbose_flag;	/**< @brief Launch the JVM w/ verbose output flags. (default=off).  */
  const char *verbose_help; /**< @brief Launch the JVM w/ verbose output flags. help description.  */
  int debug_port_arg;	/**< @brief Set the port to use for the debugger. (default='5005').  */
  char * debug_port_orig;	/**< @brief Set the port to use for the debugger. original value given at command line.  */
  const char *debug_port_help; /**< @brief Set the port to use for the debugger. help description.  */
  int debug_noha_flag;	/**< @brief Launch with CLC in debug mode (no state management). (default=off).  */
  const char *debug_noha_help; /**< @brief Launch with CLC in debug mode (no state management). help description.  */
  int debug_suspend_flag;	/**< @brief Force debugger to wait at main(). (default=off).  */
  const char *debug_suspend_help; /**< @brief Force debugger to wait at main(). help description.  */
  int profile_flag;	/**< @brief Launch with jprofiler enabled. (default=off).  */
  const char *profile_help; /**< @brief Launch with jprofiler enabled. help description.  */
  char * profiler_home_arg;	/**< @brief Set the home for jprofiler. (default='/opt/profile').  */
  char * profiler_home_orig;	/**< @brief Set the home for jprofiler. original value given at command line.  */
  const char *profiler_home_help; /**< @brief Set the home for jprofiler. help description.  */
  char * agentlib_arg;	/**< @brief Launch with agentlib enabled..  */
  char * agentlib_orig;	/**< @brief Launch with agentlib enabled. original value given at command line.  */
  const char *agentlib_help; /**< @brief Launch with agentlib enabled. help description.  */
  
  unsigned int help_given ;	/**< @brief Whether help was given.  */
  unsigned int full_help_given ;	/**< @brief Whether full-help was given.  */
  unsigned int version_given ;	/**< @brief Whether version was given.  */
  unsigned int user_given ;	/**< @brief Whether user was given.  */
  unsigned int home_given ;	/**< @brief Whether home was given.  */
  unsigned int extra_version_given ;	/**< @brief Whether extra-version was given.  */
  unsigned int initialize_given ;	/**< @brief Whether initialize was given.  */
  unsigned int upgrade_given ;	/**< @brief Whether upgrade was given.  */
  unsigned int upgrade_old_version_given ;	/**< @brief Whether upgrade-old-version was given.  */
  unsigned int upgrade_old_dir_given ;	/**< @brief Whether upgrade-old-dir was given.  */
  unsigned int upgrade_force_given ;	/**< @brief Whether upgrade-force was given.  */
  unsigned int bind_addr_given ;	/**< @brief Whether bind-addr was given.  */
  unsigned int mcast_addr_given ;	/**< @brief Whether mcast-addr was given.  */
  unsigned int bootstrap_host_given ;	/**< @brief Whether bootstrap-host was given.  */
  unsigned int force_remote_bootstrap_given ;	/**< @brief Whether force-remote-bootstrap was given.  */
  unsigned int define_given ;	/**< @brief Whether define was given.  */
  unsigned int fork_given ;	/**< @brief Whether fork was given.  */
  unsigned int kill_given ;	/**< @brief Whether kill was given.  */
  unsigned int pidfile_given ;	/**< @brief Whether pidfile was given.  */
  unsigned int db_home_given ;	/**< @brief Whether db-home was given.  */
  unsigned int fdlimit_given ;	/**< @brief Whether fdlimit was given.  */
  unsigned int log_level_given ;	/**< @brief Whether log-level was given.  */
  unsigned int log_appender_given ;	/**< @brief Whether log-appender was given.  */
  unsigned int exhaustive_given ;	/**< @brief Whether exhaustive was given.  */
  unsigned int exhaustive_db_given ;	/**< @brief Whether exhaustive-db was given.  */
  unsigned int exhaustive_user_given ;	/**< @brief Whether exhaustive-user was given.  */
  unsigned int exhaustive_cc_given ;	/**< @brief Whether exhaustive-cc was given.  */
  unsigned int exhaustive_external_given ;	/**< @brief Whether exhaustive-external was given.  */
  unsigned int out_given ;	/**< @brief Whether out was given.  */
  unsigned int err_given ;	/**< @brief Whether err was given.  */
  unsigned int remote_dns_given ;	/**< @brief Whether remote-dns was given.  */
  unsigned int remote_cloud_given ;	/**< @brief Whether remote-cloud was given.  */
  unsigned int remote_walrus_given ;	/**< @brief Whether remote-walrus was given.  */
  unsigned int remote_storage_given ;	/**< @brief Whether remote-storage was given.  */
  unsigned int disable_iscsi_given ;	/**< @brief Whether disable-iscsi was given.  */
  unsigned int disable_cloud_given ;	/**< @brief Whether disable-cloud was given.  */
  unsigned int disable_walrus_given ;	/**< @brief Whether disable-walrus was given.  */
  unsigned int disable_dns_given ;	/**< @brief Whether disable-dns was given.  */
  unsigned int disable_storage_given ;	/**< @brief Whether disable-storage was given.  */
  unsigned int java_home_given ;	/**< @brief Whether java-home was given.  */
  unsigned int jvm_name_given ;	/**< @brief Whether jvm-name was given.  */
  unsigned int jvm_args_given ;	/**< @brief Whether jvm-args was given.  */
  unsigned int jmx_given ;	/**< @brief Whether jmx was given.  */
  unsigned int debug_given ;	/**< @brief Whether debug was given.  */
  unsigned int verbose_given ;	/**< @brief Whether verbose was given.  */
  unsigned int debug_port_given ;	/**< @brief Whether debug-port was given.  */
  unsigned int debug_noha_given ;	/**< @brief Whether debug-noha was given.  */
  unsigned int debug_suspend_given ;	/**< @brief Whether debug-suspend was given.  */
  unsigned int profile_given ;	/**< @brief Whether profile was given.  */
  unsigned int profiler_home_given ;	/**< @brief Whether profiler-home was given.  */
  unsigned int agentlib_given ;	/**< @brief Whether agentlib was given.  */

} ;

/** @brief The additional parameters to pass to parser functions */
struct arguments_params
{
  int override; /**< @brief whether to override possibly already present options (default 0) */
  int initialize; /**< @brief whether to initialize the option structure eucalyptus_opts (default 1) */
  int check_required; /**< @brief whether to check that all required options were provided (default 1) */
  int check_ambiguity; /**< @brief whether to check for options already specified in the option structure eucalyptus_opts (default 0) */
  int print_errors; /**< @brief whether getopt_long should print an error message for a bad option (default 1) */
} ;

/** @brief the purpose string of the program */
extern const char *eucalyptus_opts_purpose;
/** @brief the usage string of the program */
extern const char *eucalyptus_opts_usage;
/** @brief all the lines making the help output */
extern const char *eucalyptus_opts_help[];
/** @brief all the lines making the full help output (including hidden options) */
extern const char *eucalyptus_opts_full_help[];

/**
 * The command line parser
 * @param argc the number of command line options
 * @param argv the command line options
 * @param args_info the structure where option information will be stored
 * @return 0 if everything went fine, NON 0 if an error took place
 */
int arguments (int argc, char **argv,
  struct eucalyptus_opts *args_info);

/**
 * The command line parser (version with additional parameters - deprecated)
 * @param argc the number of command line options
 * @param argv the command line options
 * @param args_info the structure where option information will be stored
 * @param override whether to override possibly already present options
 * @param initialize whether to initialize the option structure my_args_info
 * @param check_required whether to check that all required options were provided
 * @return 0 if everything went fine, NON 0 if an error took place
 * @deprecated use arguments_ext() instead
 */
int arguments2 (int argc, char **argv,
  struct eucalyptus_opts *args_info,
  int override, int initialize, int check_required);

/**
 * The command line parser (version with additional parameters)
 * @param argc the number of command line options
 * @param argv the command line options
 * @param args_info the structure where option information will be stored
 * @param params additional parameters for the parser
 * @return 0 if everything went fine, NON 0 if an error took place
 */
int arguments_ext (int argc, char **argv,
  struct eucalyptus_opts *args_info,
  struct arguments_params *params);

/**
 * Save the contents of the option struct into an already open FILE stream.
 * @param outfile the stream where to dump options
 * @param args_info the option struct to dump
 * @return 0 if everything went fine, NON 0 if an error took place
 */
int arguments_dump(FILE *outfile,
  struct eucalyptus_opts *args_info);

/**
 * Save the contents of the option struct into a (text) file.
 * This file can be read by the config file parser (if generated by gengetopt)
 * @param filename the file where to save
 * @param args_info the option struct to save
 * @return 0 if everything went fine, NON 0 if an error took place
 */
int arguments_file_save(const char *filename,
  struct eucalyptus_opts *args_info);

/**
 * Print the help
 */
void arguments_print_help(void);
/**
 * Print the full help (including hidden options)
 */
void arguments_print_full_help(void);
/**
 * Print the version
 */
void arguments_print_version(void);

/**
 * Initializes all the fields a arguments_params structure 
 * to their default values
 * @param params the structure to initialize
 */
void arguments_params_init(struct arguments_params *params);

/**
 * Allocates dynamically a arguments_params structure and initializes
 * all its fields to their default values
 * @return the created and initialized arguments_params structure
 */
struct arguments_params *arguments_params_create(void);

/**
 * Initializes the passed eucalyptus_opts structure's fields
 * (also set default values for options that have a default)
 * @param args_info the structure to initialize
 */
void arguments_init (struct eucalyptus_opts *args_info);
/**
 * Deallocates the string fields of the eucalyptus_opts structure
 * (but does not deallocate the structure itself)
 * @param args_info the structure to deallocate
 */
void arguments_free (struct eucalyptus_opts *args_info);

/**
 * Checks that all the required options were specified
 * @param args_info the structure to check
 * @param prog_name the name of the program that will be used to print
 *   possible errors
 * @return
 */
int arguments_required (struct eucalyptus_opts *args_info,
  const char *prog_name);


#ifdef __cplusplus
}
#endif /* __cplusplus */
#endif /* EUCALYPTUS_OPTS_H */
